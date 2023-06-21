package org.yearup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Application implements CommandLineRunner {

    private ProductDao dao;

    @Autowired
    public Application(ProductDao dao){
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {

        Product p1 = new Product("Beans", "Food", 2.00);
        Product p2 = new Product("Tuna", "Food", 3.25);

        Product p = null;

        try {
            dao.add(p1);
            dao.add(p2);

            p = dao.findByProductId(101L);
        } catch (BadKeyException e) {
            throw new RuntimeException(e);
        }

        System.out.println(p);

    }
}
