package com.instant.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity for all sorts of producing properties
 * @author Teodor Rupi
 */
@Entity
@Table(name = "clients")
@SolrDocument(solrCoreName = "collection1")
public class Client extends BaseEntity{

    @Column(name = "registered_name")
    @NotEmpty
    protected String registeredName;

    @Column(name = "location")
    @NotEmpty
    protected String location;

    public String getRegisteredName() {
        return this.registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
