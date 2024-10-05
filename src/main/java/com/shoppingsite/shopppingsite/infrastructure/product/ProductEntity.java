package com.shoppingsite.shopppingsite.infrastructure.product;

import com.shoppingsite.shopppingsite.domain.product.Product;
import com.shoppingsite.shopppingsite.infrastructure.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private Integer price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "image", columnDefinition = "JSON")
    private String image = "";

    @Column(name = "description",columnDefinition = "TEXT")
    private String description = "";

    public static ProductEntity of(String name, String size, String color, Integer price, Integer stock) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.name = name;
        productEntity.size = size;
        productEntity.color = color;
        productEntity.price = price;
        productEntity.stock = stock;
        return productEntity;
    }

    public static ProductEntity of(String name, String size, String color, Integer price, Integer stock, String image, String description) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.name = name;
        productEntity.size = size;
        productEntity.color = color;
        productEntity.price = price;
        productEntity.stock = stock;
        productEntity.image = image != null ? image : "";
        productEntity.description = description != null ? description : "";
        return productEntity;
    }

    public Product toProduct() {
        return Product.of(getId(), name, size, color, price, stock, image, description);
    }
}
