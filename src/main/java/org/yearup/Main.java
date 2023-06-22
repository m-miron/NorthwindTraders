package org.yearup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

}

//        ApplicationContext context = SpringApplication.run(Main.class, args);//Obtain the application context
//        Application application = context.getBean(Application.class);//Retrieve the Application bean using getBean() method.
//        application.run();


//        ApplicationContext context = SpringApplication.run(Main.class, args);
//        NorthwindApplication northwindApplication = context.getBean(NorthwindApplication.class);
//        northwindApplication.run(args);}}
