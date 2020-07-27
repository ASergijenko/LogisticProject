package com.cargoproject;

import com.cargoproject.logisticproject.services.uploading.StorageProperties;
import com.cargoproject.logisticproject.services.uploading.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}




/*
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
