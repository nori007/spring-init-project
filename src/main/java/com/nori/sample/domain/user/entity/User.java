package com.nori.sample.domain.user.entity;

import com.nori.sample.global.BaseEntity;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    private String loginId;

    private String Password;

    private String name;

    private String email;
}
