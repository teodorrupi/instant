package com.instant.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Entity class for shared properties
 * @author Teodor Rupi
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotEmpty
    @Column(name = "name")
    protected String name;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
