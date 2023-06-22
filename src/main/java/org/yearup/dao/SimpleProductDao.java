package org.yearup.dao;

import org.springframework.stereotype.Component;
import org.yearup.application.BadKeyException;
import org.yearup.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimpleProductDao implements ProductDao {

    private Long idBase = 100L;

    private Map<Long, Product> products = new HashMap<>();

    @Override
    public Long add(Product product) throws BadKeyException {
        if (product.getProductId() != null) {
            throw new BadKeyException("Busted");
        }
            Long key = Long.valueOf(idBase++);
            Product p = new Product(key,
                    product.getName(), product.getCategory(), product.getPrice());
            products.put(key, p);
            return key;

    }

    @Override
    public List<Product> getAll() {
        return products.values().stream().toList();
    }


    @Override
    public Product findByProductId(Long productId) throws BadKeyException {
        if (products.containsKey(productId)){
            return products.get(productId);
        }
        else {
            throw new BadKeyException("Product ID not found");
        }
    }
}
