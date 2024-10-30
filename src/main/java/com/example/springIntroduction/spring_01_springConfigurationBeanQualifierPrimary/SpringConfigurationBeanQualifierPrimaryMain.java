package com.example.springIntroduction.spring_01_springConfigurationBeanQualifierPrimary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;

public class SpringConfigurationBeanQualifierPrimaryMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean(Integer.class));
        System.out.println(context.getBean("homeTownAddress"));
        System.out.println(context.getBean("workAddress"));
        System.out.println(context.getBean("workPerson"));
        System.out.println(context.getBean("homePerson"));
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean("specialPerson"));

        Arrays.stream(context.getBeanDefinitionNames()).forEach(SpringConfigurationBeanQualifierPrimaryMain::printBean);
    }
    public static void printBean(String beanName) {
        System.out.println(STR."Bean name: \{beanName}");
    }
}
