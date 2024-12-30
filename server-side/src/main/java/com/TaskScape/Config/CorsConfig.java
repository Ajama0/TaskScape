package com.TaskScape.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * allows us to define the configurations for CORS
     * essentially we can define which origin can access our resources and which endpoints they have access to
     * The browser by default disabled CORS meaning 2 servers with different origins can not share data
     * with this function we override the implementation of addCorsMapping to define our own origin
     *with java 8 default methods we can only need to define implementations of methods we want
     */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        //the origin can access all path patterns
        //the origin is defined as out server hosted in the client-side
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:62527/");
    }

}
