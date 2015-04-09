package com.codex.busel.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "PK", sequenceName = "t_user_seq")
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK")
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "F_ROLE_ID")
    @ManyToOne // todo (fetch = FetchType.LAZY,optional=true)
    private Role role;

}
