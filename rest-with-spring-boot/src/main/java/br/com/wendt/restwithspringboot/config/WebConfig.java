package br.com.wendt.restwithspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //        configurer.favorParameter(false)
        //            .ignoreAcceptHeader(false)
        //            .defaultContentType(MediaType.APPLICATION_JSON)
        //            .mediaType("json", MediaType.APPLICATION_JSON)
        //            .mediaType("xml", MediaType.APPLICATION_XML);

        // nao vai mais aceitar o tipo de arquivo via extensao
        //        configurer.favorPathExtension(false)
        //                .favorParameter(true)
        //                .parameterName("mediaType")
        //                .useRegisteredExtensionsOnly(false)
        //                .defaultContentType(MediaType.APPLICATION_JSON)
        //                .mediaType("json", MediaType.APPLICATION_JSON)
        //                .mediaType("xml", MediaType.APPLICATION_XML);

        configurer.favorPathExtension(false)
            .favorParameter(false)
            .ignoreAcceptHeader(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML);
    }

}