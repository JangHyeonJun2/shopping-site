package com.shoppingsite.shopppingsite.domain;

import com.shoppingsite.shopppingsite.domain.product.ProductService;
import com.shoppingsite.shopppingsite.domain.product.Product;
import com.shoppingsite.shopppingsite.domain.product.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품 리스트 조회에 성공한다")
    public void successToGetAllProducts() {
        // given
        Product product1= Product.of(1L, "JEANS", "M", "SAND BRUSH", 97000, 50);
        Product product2= Product.of(2L, "T-SHIRTS", "FREE", "WHITE", 49000, 37);
        Product product3= Product.of(3L, "CAP", "FREE", "GREEN", 49000, 8);
        productRepository.saveAll(List.of(product1, product2, product3));

        // when
        List<Product> products = productService.getAllProducts();

        // then
        assertThat(products.get(0).getPrice()).isEqualTo(product1.getPrice());
        assertThat(products.get(1).getName()).isEqualTo(product2.getName());
        assertThat(products.get(2).getStock()).isEqualTo(product3.getStock());
    }
}
