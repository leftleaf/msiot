package com.example.data;

import com.example.data.filter.DataFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DataEdgeService {
    public static void main(String args[]) {
        SpringApplication.run(DataEdgeService.class, args);
    }
    @Bean
    public FilterRegistrationBean<DataFilter> filterRegistrationBean() {
        FilterRegistrationBean<DataFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        DataFilter dataFilter = new DataFilter();
        filterRegistrationBean.setFilter(dataFilter);

        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
