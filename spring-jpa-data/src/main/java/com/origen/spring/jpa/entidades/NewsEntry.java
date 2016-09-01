//package com.origen.spring.jpa.entidades;
//
//import com.origen.spring.jpa.model.*;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//import com.origen.spring.jpa.util.JsonViews;
//import javax.persistence.Basic;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.codehaus.jackson.map.annotate.JsonView;
//
//
///**
// * JPA Annotated Pojo that represents a news entry.
// * 
// * @author Philip W. Sorst <philip@sorst.net>
// */
//@javax.persistence.Entity
//@Table(name = "EP_NEWSENTRY")
//public class NewsEntry implements Entity
//{
//    @Id
//    @Basic(optional = false)
//    @Column(name = "ID")
//    private Long id;
//    @Column(name = "FECHA")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date fecha;
//    @Column(name = "CONTENIDO")
//    private String contenido;
//
//	@Id
//	@GeneratedValue
//	private Long id;
//        
//         @Id
//    @Basic(optional = false)
//    @Column(name = "USER_ID")
//    private String id;
//    @Basic(optional = false)
//    @Column(name = "USER_NOMBR")
//    private String name;
//
//	@Column
//        @Temporal(TemporalType.DATE)
//	private Date date;
//
//	@Column
//	private String content;
//
//
//	public NewsEntry()
//	{
//		this.date = new Date();
//	}
//
//
//	@JsonView(JsonViews.Admin.class)
//	public Long getId()
//	{
//		return this.id;
//	}
//
//
//	@JsonView(JsonViews.User.class)
//	public Date getDate()
//	{
//		return this.date;
//	}
//
//
//	public void setDate(Date date)
//	{
//		this.date = date;
//	}
//
//
//	@JsonView(JsonViews.User.class)
//	public String getContent()
//	{
//		return this.content;
//	}
//
//
//	public void setContent(String content)
//	{
//		this.content = content;
//	}
//
//
//	@Override
//	public String toString()
//	{
//		return String.format("NewsEntry[%d, %s]", this.id, this.content);
//	}
//
//    public NewsEntry(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }
//
//    public String getContenido() {
//        return contenido;
//    }
//
//    public void setContenido(String contenido) {
//        this.contenido = contenido;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof NewsEntry)) {
//            return false;
//        }
//        NewsEntry other = (NewsEntry) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.origen.spring.jpa.model.NewsEntry[ id=" + id + " ]";
//    }
//
//}