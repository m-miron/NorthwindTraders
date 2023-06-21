package org.yearup;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimpleProductDao implements ProductDao {

    private Long idBase = 100L;

    private Map<Long, Product> products = new HashMap<>();

    @Override
    public Long add(Product product) {

        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }


    @Override
    public Product findByProductId() {
        return null;
    }
}
