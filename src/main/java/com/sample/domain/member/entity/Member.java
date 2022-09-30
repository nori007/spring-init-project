package com.sample.domain.member.entity;

import com.sample.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {

    private String loginId;

    private String password;

    private String name;

    private String email;

    @Builder
    public Member(String loginId, String password, String name, String email) {
        super();
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
