package com.example.springIntroduction.SpringFeature_03;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class ClassDependency {
    public void someMethod() {
        System.out.println("ClassDependency method called");
    }
}

@Component
class ClassSuper {
    ClassDependency classDependency;
    public ClassSuper(ClassDependency classDependency)
    {
        this.classDependency = classDependency;
        System.out.println("ClassSuper bean initialized");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Method running post construction");
        classDependency.someMethod();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Cleaning up...");
    }
}

@Configuration
@ComponentScan
public class PostConstructPreDestroyMethodMain {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(PostConstructPreDestroyMethodMain.class)){

        }
    }
}
