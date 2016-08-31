/*
 * Copyright 2016 JuglarM.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.epitafio.web.controller;


import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.origen.spring.jpa.beans.HTMLMain;
import com.origen.spring.jpa.service.PersonalizadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/personalizacion")
public class PersonalizacionController {

	@Autowired
	private PersonalizadorService userService;
    /**
     *
     * @param distrito
     * @param idbussines
     *
     * @return
     */
    @Path("obtenerHtmlMain")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public HTMLMain authenticate(@FormParam("distrito") String distrito, @FormParam("idbussines") String idbussines) {
        HTMLMain main = userService.obtenerHtmlPersonalizado(distrito,idbussines);
        return main;
    }
}
