package com.div.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import java.nio.charset.StandardCharsets;

/**
 * Created by Div on 2018-05-09.
 */
@Configuration
public class ThymeleafConfig {
    @Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addDialect(new SpringSecurityDialect());
        templateEngine.addTemplateResolver(htmlTemplateResolver());
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver(){
        SpringResourceTemplateResolver htmlTemplateResolver = new SpringResourceTemplateResolver();
        htmlTemplateResolver.setPrefix("classpath:/templates/");
        htmlTemplateResolver.setSuffix(".html");
        htmlTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return htmlTemplateResolver;
    }
}
