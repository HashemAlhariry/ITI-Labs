package com.example;


import gov.iti.jets.ConsoleHelloService;
import gov.iti.jets.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Properties.class)
@ConditionalOnClass(HelloService.class)
public class HelloServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService(Properties properties){
        return  new ConsoleHelloService(properties.getPrefix(),properties.getSuffix());
    }


}
