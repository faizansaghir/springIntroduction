package com.example.springIntroduction.SpringFeature_04;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class XmlApplicationContextMain {
    public static void main(String[] args) {
        try(var context = new ClassPathXmlApplicationContext("contextApplication.xml")){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

        }
    }
}
