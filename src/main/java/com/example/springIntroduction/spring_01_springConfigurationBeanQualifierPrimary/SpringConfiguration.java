package com.example.springIntroduction.spring_01_springConfigurationBeanQualifierPrimary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Address(String city, Integer pincode) {}
record Person(String name, Integer age, Address address){}
@Configuration
public class SpringConfiguration {

    @Bean
    public String name(){
        return "Faizan";
    }

    @Bean
    public Integer age(){
        return 26;
    }

    @Bean(name = "homeTownAddress")
    public Address homeAddress(){
        return new Address("Ranchi", 834001);
    }
    
    @Bean
    public Address workAddress(){
        return new Address("Bangalore", 560048);
    }

    @Bean
    @Primary
    public Address sisterHomeAddress(){
        return new Address("Bangalore", 548101);
    }

    @Bean
    public Person workPerson(){
        return new Person(name(), age(), workAddress());
    }

    @Bean
    public Person homePerson(String name, Integer age, Address homeTownAddress){
        return new Person(name, age, homeTownAddress);
    }

    @Bean
    @Primary
    public Person defaultPerson(String name, Integer age, Address defaultAddress){
        return new Person(name, age, defaultAddress);
    }

    @Bean
    @Qualifier("secretAddress")
    public Address specialAddress(){
        return new Address("Ranchi", 834002);
    }

    @Bean
    public Person specialPerson(String name, Integer age,@Qualifier("secretAddress") Address address) {
        return new Person(name, age, address);
    }
}
