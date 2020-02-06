package club.chatnt.config;

/**
 * 时间:20:37
 * 作者：Maibenben
 **/

import club.chatnt.converter.StringToLocalDateConverter;
import club.chatnt.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 时间:12:38
 * 作者：Maibenben
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor()).excludePathPatterns("/user/login").excludePathPatterns("/service/login").excludePathPatterns("/css/**").excludePathPatterns("/images/**").excludePathPatterns("/js/**").excludePathPatterns("/lib/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\Program Files\\chatnt\\");


    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLocalDateConverter());
    }
}

