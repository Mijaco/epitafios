/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origen.spring.jpa.model;

import com.origen.spring.jpa.util.JsonViews;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 *
 * @author UserTBS1
 */
@javax.persistence.Entity
@Table(name = "EP_NEWSENTRY")
public class EpNewsentry implements Entity {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ENTRY_ID")
    private Long id;
    @Column(name = "ENTRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "ENTRY_CONTENT")
    private String content;

    public EpNewsentry() {
        this.date = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(JsonViews.Admin.class)
    public Long getId() {
        return this.id;
    }

    @JsonView(JsonViews.User.class)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonView(JsonViews.User.class)
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EpNewsentry)) {
            return false;
        }
        EpNewsentry other = (EpNewsentry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.origen.spring.jpa.model.EpNewsentry[ entryId=" + id + " ]";
    }

}
