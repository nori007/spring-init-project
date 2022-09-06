package com.daou.bizmailer.s.domain.user.entity;

import com.daou.bizmailer.s.global.BaseEntity;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    private String loginId;

    private String Password;

    private String name;

    private String email;
}
