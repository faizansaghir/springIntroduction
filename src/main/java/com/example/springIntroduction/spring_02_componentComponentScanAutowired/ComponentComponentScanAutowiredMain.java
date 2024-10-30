package com.example.springIntroduction.spring_02_componentComponentScanAutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
record Address(@Qualifier("city") String city, Integer pincode) {}

@Component
//record Person(String name, Integer age, Address address){}
class Person{
    @Autowired
    String name;
    Integer age;
    Address address;

    @Autowired
    public Person(Address address){
        this.address=address;
    }

    @Autowired
    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString(){
        return name+"\t"+age+"\t"+address;
    }
}
@Configuration
@ComponentScan
public class ComponentComponentScanAutowiredMain {

    @Bean
    public String name(){
        return "Faizan";
    }

    @Bean
    public String city(){
        return "Bangalore";
    }

    @Bean
    public Integer age(){
        return 26;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentComponentScanAutowiredMain.class);
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean(Address.class));

        Arrays.stream(context.getBeanDefinitionNames()).forEach(ComponentComponentScanAutowiredMain::printBean);
    }
    public static void printBean(String beanName) {
        System.out.println(STR."Bean name: \{beanName}");
    }
}
