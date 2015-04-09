package com.codex.busel.model;

import javax.persistence.*;

/**
 * Created by u on 09.04.2015.
 */
@Entity
@Table(name = "DEVELOPER")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
