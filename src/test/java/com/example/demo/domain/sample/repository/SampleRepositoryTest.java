package com.example.demo.domain.sample.repository;

import com.example.demo.domain.sample.entity.Sample;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleRepositoryTest {

    @Autowired
    SampleRepository sampleRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testSampleSave() throws Exception {
        Sample sample = Sample.builder().name("hyunggil89").email("hyunggil89@daou.co.kr").build();

        Sample saveSample = sampleRepository.save(sample);
        Sample findSample = sampleRepository.findById(saveSample.getId())
                .orElseThrow(() -> new IllegalArgumentException("not found data"));

        Assertions.assertThat(findSample.getId()).isEqualTo(saveSample.getId());
        Assertions.assertThat(findSample.getName()).isEqualTo(saveSample.getName());
    }
}
