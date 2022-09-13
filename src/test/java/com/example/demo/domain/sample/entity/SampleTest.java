package com.example.demo.domain.sample.entity;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleTest {

    @Test
    public void testSample() throws Exception {
        String name = "hyunggil89";
        String email = "hyunggil89@daou.co.kr";

        Sample sample = Sample.builder().name(name).email(email).build();

        Assertions.assertThat(sample.getName()).isEqualTo(name);
        Assertions.assertThat(sample.getEmail()).isEqualTo(email);
    }
}
