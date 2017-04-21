package com.abhishek.jackson.app;

import com.abhishek.jackson.annotator.JacksonSampleAnnotator;
import com.abhishek.jackson.app.filter.JacksonSampleFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 *
 * @author Abhishek Bhardwaj
 */
@SpringBootApplication
public class JacksonAnnotationSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JacksonAnnotationSampleApplication.class, args);
    }
    
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.filters( new SimpleFilterProvider().addFilter( JacksonSampleAnnotator.SKIP_SERIALIZE_FILTER, new JacksonSampleFilter() ) );
        return builder;
    }
    
}
