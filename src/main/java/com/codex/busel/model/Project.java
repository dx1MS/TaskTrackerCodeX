package com.codex.busel.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "PK", sequenceName = "t_project_seq")
@Table(name = "PROJECT")
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    @Column(name = "PROJECT_ID")
    private Long projectId;

    @Column(name = "PROJECT_NAME")
    private String projectName;
}
