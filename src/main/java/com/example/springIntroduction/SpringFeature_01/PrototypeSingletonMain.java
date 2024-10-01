package com.example.springIntroduction.SpringFeature_01;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalScope {

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeScope {

}

@Configuration
@ComponentScan
public class PrototypeSingletonMain {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(PrototypeSingletonMain.class)){
            System.out.println(context.getBean(NormalScope.class));
            System.out.println(context.getBean(NormalScope.class));
            System.out.println(context.getBean(NormalScope.class));

            System.out.println(context.getBean(PrototypeScope.class));
            System.out.println(context.getBean(PrototypeScope.class));
            System.out.println(context.getBean(PrototypeScope.class));
        }
    }
}
