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
public class Product extends BaseEntity{

    @Column(name = "registered_name")
    @NotEmpty
    protected String registeredName;

    public String getRegisteredName() {
        return this.registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }
}
