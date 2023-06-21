package org.yearup;

import java.util.List;

public interface ProductDao {

    Long add(Product product) throws BadKeyException;

    List<Product> getAll();

    Product findByProductId(Long productId) throws BadKeyException;
}
