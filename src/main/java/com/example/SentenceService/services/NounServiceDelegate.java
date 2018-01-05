package com.example.SentenceService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class NounServiceDelegate {
    private @Value("${spring.cloud.kubernetes.discovery.enabled}") Boolean discoveryEnabled;
    private @Value("${services.domain") String domain;
    private @Value("${services.nounservice.name}") String name;
    private @Value("${services.nounservice.port}") String port;


    @Autowired
    RestTemplate restTemplate;

    public String callNounService()
    {
        String url = "hhtp:://" + this.name + "." + this.domain + ":" + this.port;
        System.out.println("Trying Nounservice at " + url);

        String response = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, "").getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}