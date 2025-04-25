package com.task.task.component;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebclientComponent {

    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

}
