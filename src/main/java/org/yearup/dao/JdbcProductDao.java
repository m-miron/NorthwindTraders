package org.yearup.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.yearup.application.BadKeyException;
import org.yearup.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class JdbcProductDao implements ProductDao {
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Long add(Product product) throws BadKeyException {
        Long i = 0L;
        try {
            Connection mysqlConnection = dataSource.getConnection();
            PreparedStatement statement = mysqlConnection.prepareStatement("""
                    INSERT INTO products (ProductName, CategoryID, UnitPrice)
                    VALUES (?,?,?)
                    """, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory());
            statement.setDouble(3, product.getPrice());
            Integer i2 = statement.executeUpdate();
            ResultSet r = statement.getGeneratedKeys();
            while (r.next()){
                i = r.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try {
            Connection mysqlConnection = dataSource.getConnection();
            PreparedStatement statement = mysqlConnection.prepareStatement("""
                            SELECT *
                            FROM products
                            """);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product p = new Product(
                        result.getLong("ProductID"),
                        result.getString("ProductName"),
                        result.getString("CategoryID"),
                        result.getDouble("UnitPrice")
                );
                productList.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public Product findByProductId(Long productId) throws BadKeyException {
        Product p = null;
        try {
            Connection mysqlConnection = dataSource.getConnection();
            PreparedStatement statement = mysqlConnection.prepareStatement("""
                            SELECT *
                            FROM products
                            WHERE ProductID = ?
                            """);
            statement.setLong(1,productId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                p = new Product(
                        result.getLong("ProductID"),
                        result.getString("ProductName"),
                        result.getString("CategoryID"),
                        result.getDouble("UnitPrice")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }
}

