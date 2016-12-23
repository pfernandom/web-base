package com.untitled;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/static/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(3600*24).setCacheControl(CacheControl.maxAge(1,TimeUnit.DAYS));
        }
        if (!registry.hasMappingForPattern("static/**")) {
            registry.addResourceHandler("static/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS).setCachePeriod(3600*24).setCacheControl(CacheControl.maxAge(1,TimeUnit.DAYS));
        }
    }

}