package com.example.RestTemplateApplicationTeaster.configuaration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import java.time.Duration;

@Configuration
public class RestTemplateBuildConfigurer {
    @Bean
    public RestTemplate restTemplateBuilder( RestTemplateBuilder builder ){
        UriTemplateHandler templateHandler = new RootUriTemplateHandler("http://localhost:9090/employee/v1/employees");
        return  builder.uriTemplateHandler ( templateHandler ).setConnectTimeout ( Duration.ofMillis ( 2000 ) ).build ();
    }
}
