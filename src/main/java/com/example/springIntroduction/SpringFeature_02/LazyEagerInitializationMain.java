package com.example.springIntroduction.SpringFeature_02;


import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
class ClassB {
    public ClassB(){
        System.out.println("Bean B initialized");
    }
}

@Component
@Lazy
class ClassA {
    public ClassA(){
        System.out.println("Bean A initialized");
    }
}

@Configuration
@ComponentScan
public class LazyEagerInitializationMain {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(LazyEagerInitializationMain.class)){
            System.out.println("Context initialization completed");
            System.out.println(context.getBean(ClassB.class));
            System.out.println(context.getBean(ClassA.class));
        }
    }
}
