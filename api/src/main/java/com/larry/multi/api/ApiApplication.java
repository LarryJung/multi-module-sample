package com.larry.multi.api;

import com.larry.multi.core.SampleEntity;
import com.larry.multi.core.SampleEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EntityScan("com.larry.multi.*")
@EnableJpaRepositories("com.larry.multi.*")
@RestController
@SpringBootApplication
public class ApiApplication {

    private final SampleEntityRepository repository;

    public ApiApplication(SampleEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SampleEntity> findAll() {
        return repository.findAll();
    }

    @GetMapping("/save")
    public SampleEntity saveOne() {
        return repository.save(new SampleEntity());
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
