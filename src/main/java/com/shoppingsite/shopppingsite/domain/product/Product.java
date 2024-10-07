package com.shoppingsite.shopppingsite.domain.product;

import com.shoppingsite.shopppingsite.common.exception.InvalidParamException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Product {

    @Id
    private Long id;
    private String name;
    private String size;
    private String color;
    private Integer price;
    private Integer stock;
    private String image = "";
    private String description = "";

    public static Product of(Long id, String name, String size, String color, Integer price, Integer stock) {
        Product product = new Product();
        product.id = id;
        product.name = name;
        product.size = size;
        product.color = color;
        product.price = price;
        product.stock = stock;
        return product;
    }

    public static Product of(Long id, String name, String size, String color, Integer price, Integer stock, String image, String description) {
        Product product = new Product();
        product.id = id;
        product.name = name;
        product.size = size;
        product.color = color;
        product.price = price;
        product.stock = stock;
        product.image = image != null ? image : "";
        product.description = description != null ? description : "";
        return product;
    }

    public void reduceStock(Integer reduceAmount) {
        if (this.stock < reduceAmount) {
            throw new InvalidParamException("재고 차감 불가: 입력한 값이 재고보다 많습니다.");
        }
        this.stock -= reduceAmount;
    }
}
