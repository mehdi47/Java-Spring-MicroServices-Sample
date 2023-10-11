package com.seleniumexpress.employeeapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {

    @Value("${addressservice.base.url}") // if you use the addressbaseurl in the constructor it will be null, you need to add it to the constructor like this
    private String adressbaseURL; // @Value("${addressservice.base.url}") String adressbaseURL

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Bean
    public WebClient webClient(){
        return WebClient
                .builder()
                .baseUrl(adressbaseURL)
                .build();
    }
}
