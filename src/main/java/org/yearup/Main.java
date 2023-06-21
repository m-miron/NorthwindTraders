package org.yearup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        ProductDao dao = ctx.getBean(ProductDao.class);

        Product p1 = new Product("Beans", "Food", 2.00);
        Product p2 = new Product("Tuna", "Food", 3.25);

        dao.add(p1);
        dao.add(p2);

        Product p = dao.findByProductId(101L);

        System.out.println(p);

    }
}
