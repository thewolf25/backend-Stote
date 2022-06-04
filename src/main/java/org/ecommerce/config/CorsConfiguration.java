//package org.ecommerce.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//
//public class CorsConfiguration {
//
//    @Bean
//    public WebMvcConfigurer corsConfig(){
//
//        System.out.println("yes !! I'm Here ");
//        return new WebMvcConfigurer(){
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedHeaders("*")
//                        .allowedMethods("GET","POST","PUT","DELETE")
//                        .allowedOrigins("http://localhost:4200");
//            }
//        };
//    }
//}
