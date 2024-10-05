package com.shoppingsite.shopppingsite.domain;

import com.shoppingsite.shopppingsite.common.exception.InvalidParamException;
import com.shoppingsite.shopppingsite.domain.product.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductTest {

    private Product product;

    @BeforeAll
    public void setUp() {
        product = Product.of(1L, "test", "M", "WHITE", 100000, 10);
    }

    @Test
    @DisplayName("상품 재고 차감에 성공한다")
    public void testSuccessToReduceStock() {
        // given
        Integer stock = 10;
        Integer reduceAmount = 5;

        // when
        product.reduceStock(reduceAmount);

        //then
        assertThat(product.getStock()).isEqualTo(stock - reduceAmount);
    }

    @Test
    @DisplayName("차감할 값이 재고보다 많은 경우 재고 차감에 실패한다")
    public void testFailToReduceStockWhenExceedingAvailableStock() {
        // given
        Integer invalidReduceAmount = 15;

        // when & then
        assertThrows(InvalidParamException.class, () -> {
            product.reduceStock(invalidReduceAmount);
        });
    }
}
