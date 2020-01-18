package com.boot.app.FirstBootApp.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
    	System.out.println("Entering jacksonBuilder********************************** ");
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

        builder.featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

        return builder;
    }
    @Bean
    public ObjectMapper objectMapper() {
	    	
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.WRAP_EXCEPTIONS, true);
        try {
			objectMapper.writerFor(new TypeReference<Set<String>>() { })
			.writeValueAsString(new HashSet()	);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return objectMapper;
    }
    
    
}
