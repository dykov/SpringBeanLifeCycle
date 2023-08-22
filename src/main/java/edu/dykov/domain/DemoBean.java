package edu.dykov.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DemoBean implements InitializingBean, DisposableBean,
        BeanNameAware, ApplicationContextAware {

    private String javaVersion;
    private RestTemplate restTemplate;
    private ApplicationContext applicationContext;

    public DemoBean() {
        System.out.println("### 1: Default Constructor");
    }

    @Autowired
    private void setRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        System.out.println("### 2: @Autowired setters");
    }

    @Value("${java.specification.version}")
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
        System.out.println("### 3: @Value setters, java version=" + javaVersion);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("### 4: BeanNameAware#setBeanName:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("### 5: ApplicationContextAware#setApplicationContext");
    }

    @PostConstruct
    public void init() {
        System.out.println("### 7: @PostConstruct (init method)");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("### 8: InitializingBean#afterPropertiesSet");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("### 10: @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("### 11: DisposableBean#destroy");
    }
}
