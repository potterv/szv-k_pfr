package ru.pfr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    // Static Resource Config
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Css resource.
        registry.addResourceHandler("/images/**") //
                .addResourceLocations("/WEB-INF/pages/static/images/").setCachePeriod(31556926);
        registry.addResourceHandler("/fonts/**") //
                .addResourceLocations("/WEB-INF/pages/static/fonts/").setCachePeriod(32556926);
        registry.addResourceHandler("/css/**") //
                .addResourceLocations("/WEB-INF/pages/static/css/").setCachePeriod(31356926);
        registry.addResourceHandler("/static/**") //
                .addResourceLocations("/WEB-INF/pages/static/").setCachePeriod(31546926);


    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
