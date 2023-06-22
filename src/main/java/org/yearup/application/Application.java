package org.yearup.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yearup.dao.ProductDao;
import org.yearup.model.Product;

import java.util.List;

@Component
public class Application implements CommandLineRunner {

    private ProductDao dao;

    @Autowired
    public Application(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Product> entireList = dao.getAll();
        for (Product p : entireList) {
            System.out.println(p);
        }
        Product p = dao.findByProductId(70L);
        System.out.println(p);

        Long i = dao.add(p);
        System.out.println(i);
    }
}

//        Product p1 = new Product("Beans", "Food", 2.00);
//        Product p2 = new Product("Tuna", "Food", 3.25);
//
//        Product p = null;
//
//        try {
//            dao.add(p1);
//            dao.add(p2);
//
//            p = dao.findByProductId(101L);
//        } catch (BadKeyException e) {
//            throw new RuntimeException(e);
//        }

//        System.out.println(p);
//        System.out.printf("%nProduct ID: %d%nName: %s%nCategory: %s%nPrice: $%.2f%n",
//                p.getProductId(), p.getName(), p.getCategory(), p.getPrice());}}