package com.nori.sample.domain.sampleMember.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberModel {

    private Long id;
    private String name;
    private String email;

}
