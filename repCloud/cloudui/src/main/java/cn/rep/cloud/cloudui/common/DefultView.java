package cn.rep.cloud.cloudui.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefultView extends WebMvcConfigurerAdapter {
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/").setViewName("forward:/index.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
