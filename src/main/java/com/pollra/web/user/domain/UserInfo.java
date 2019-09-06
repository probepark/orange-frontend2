package com.pollra.web.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue
    private String id;

    private String auth;

    @Column(unique = true)
    private String email;
}
