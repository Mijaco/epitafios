package com.epitafio.seguridad.rest.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import com.origen.spring.jpa.model.EpUser;

import com.epitafio.seguridad.rest.TokenUtils;
import com.epitafio.seguridad.transfer.TokenTransfer;
import com.epitafio.seguridad.transfer.UserTransfer;
import com.origen.spring.jpa.serial.UserLoad;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Component
@Path("/user")
public class UserResource
{

	@Autowired
	private UserDetailsService userService;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;


    @Path("salvarImagenLogo")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagenLogo(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {
        System.out.println("Creando Imagen  en UploadFile2");
        String uploadedFileLocation = "C:\\mytemp\\" + fileDetail.getFileName();

        // save it
        saveToFile(uploadedInputStream, uploadedFileLocation);

           String output = "File uploaded via Jersey based RESTFul Webservice to: " + uploadedFileLocation;
 
        return Response.status(200).entity(output).build();

    }
     private void saveToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) {

        try {
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
        
        
	/**
	 * Retrieves the currently logged in user.
	 * 
	 * @return A transfer containing the username and the roles.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserTransfer getUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof String && ((String) principal).equals("anonymousUser")) {
			throw new WebApplicationException(401);
		}
//		UserDetails userDetails = (UserDetails) principal;
		UserLoad userLoad = (UserLoad) principal;

		return new UserTransfer(userLoad.getName(), this.createRoleMap(userLoad));
	}


	/**
         * 
         * @param id es el DNI - > se deja como username porque asi lo trabaja spring
         * @param password
         * @param rutaInicial
         * @return 
         */
	@Path("authenticate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenTransfer authenticate(@FormParam("id") String id, @FormParam("password") String password,@FormParam("rutaInicial") String rutaInicial)
	{
            
//                Long iduser = Long.parseLong(username.trim());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, password);
		Authentication authentication = this.authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

                System.out.println("Autenticando usuario : " + id + "; pass : " + password + " ; rutainicial : " + rutaInicial);
		/*
		 * Reload user as password of authentication principal will be null after authorization and
		 * password is needed for token generation
		 */
		UserDetails userDetails = this.userService.loadUserByUsername(id);
                
                /*Mediante servicios de usuarios de bd*/
                // 1.- busco por el username 12345678
//                User usuario = new User("12345678", "pass");// este usuario obtuvimos de la bd
                
                TokenTransfer tokenObtenido = new TokenTransfer(TokenUtils.createToken(userDetails));
                System.out.println("userDetails : " + userDetails.toString());
                
		return tokenObtenido;
	}


	private Map<String, Boolean> createRoleMap(UserDetails userDetails)
	{
		Map<String, Boolean> roles = new HashMap<String, Boolean>();
		for (GrantedAuthority authority : userDetails.getAuthorities()) {
			roles.put(authority.getAuthority(), Boolean.TRUE);
		}

		return roles;
	}

}