package org.ecommerce.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

//@Component
//class SpringDataRestCustomization implements RepositoryRestConfigurer
//{
//        @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.getCorsRegistry().addMapping("/**")
//                .allowedOrigins("http://localhost:4200");
//    }
//}