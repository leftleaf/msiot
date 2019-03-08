package com.example.device;

import com.example.device.filter.DeviceFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DeviceEdgeService {
    public static void main(String args[]) {
        SpringApplication.run(DeviceEdgeService.class, args);
    }
    @Bean
    public FilterRegistrationBean<DeviceFilter> filterRegistrationBean() {
        FilterRegistrationBean<DeviceFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        DeviceFilter deviceFilter = new DeviceFilter();
        filterRegistrationBean.setFilter(deviceFilter);

        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
