package com.shoppingsite.shopppingsite.domain.product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    void saveAll(List<Product> products);
    List<Product> findAll();
}
