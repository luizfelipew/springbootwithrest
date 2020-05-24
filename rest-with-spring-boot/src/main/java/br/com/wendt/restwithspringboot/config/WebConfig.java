package br.com.wendt.restwithspringboot.config;

import br.com.wendt.restwithspringboot.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");

    @Override
    public void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }

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
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML)
            .mediaType("x-yml", MEDIA_TYPE_YML);
    }

}
