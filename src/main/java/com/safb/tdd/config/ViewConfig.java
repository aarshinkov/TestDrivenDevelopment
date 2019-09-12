package com.safb.tdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * The view configuration is responsible for finding and returning the views to the end user.
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Configuration
public class ViewConfig {

    /**
     * This bean specifies where to look for views and what extensions (suffixes) should the views be with. It also specifies
     * the format of the template as well as character encoding. It gives this resolver a priority with the serOrder() method.
     *
     * @return the template resolver
     * @author Atanas Yordanov Arshinkov
     * @since 1.0.0
     */
    @Bean
    public SpringResourceTemplateResolver srtr() {
        SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
        srtr.setPrefix("/WEB-INF/views/");
        srtr.setSuffix(".html");
        srtr.setTemplateMode("HTML");
        srtr.setCharacterEncoding("UTF-8");
        srtr.setCacheable(false);
        srtr.setOrder(1);

        return srtr;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(srtr());

        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        return viewResolver;
    }
}
