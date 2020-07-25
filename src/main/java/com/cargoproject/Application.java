package com.cargoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

/*
public class com.cargoproject.Application {

    public static void main(String[] args) throws Exception {

        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.cargoproject.SpringConfig.class);
            SortingMain main = applicationContext.getBean(SortingMain.class);
            main.execute();
        }catch (ValidationException e){
            System.out.println("Fatal error 404 " + e.getMessage());
        }
    }
}*/
