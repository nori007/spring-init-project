package com.example.demo.sample.entity;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {

    @Test
    public void testMember() throws Exception {
        String name = "hyunggil89";
        String email = "hyunggil89@daou.co.kr";

        Member member = Member.builder().name(name).email(email).build();

        Assertions.assertThat(member.getName()).isEqualTo(name);
        Assertions.assertThat(member.getEmail()).isEqualTo(email);
    }
}
