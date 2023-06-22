package org.yearup.dao;

import org.yearup.application.BadKeyException;
import org.yearup.model.Product;

import java.util.List;

public interface ProductDao {

    Long add(Product product) throws BadKeyException;

    List<Product> getAll();

    Product findByProductId(Long productId) throws BadKeyException;
}
