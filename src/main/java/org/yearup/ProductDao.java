package org.yearup;

import java.util.List;

public interface ProductDao {

    Long add(Product product);

    List<Product> getAll();

    Product findByProductId();
}
