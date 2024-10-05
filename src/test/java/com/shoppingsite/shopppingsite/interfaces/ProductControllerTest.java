package com.shoppingsite.shopppingsite.interfaces;

import com.shoppingsite.shopppingsite.Fixtures;
import com.shoppingsite.shopppingsite.domain.product.ProductService;
import com.shoppingsite.shopppingsite.interfaces.product.ProductController;
import com.shoppingsite.shopppingsite.domain.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("상품 목록 조회에 성공한다")
    public void successToGetAllProducts() throws Exception {
        // given
        Product product1 = Fixtures.product("JEANS");
        Product product2 = Fixtures.product("T-SHIRTS");
        given(productService.getAllProducts()).willReturn(
                List.of(product1, product2));

        // when & then
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpectAll(
                        jsonPath("$.result").value("SUCCESS"),
                        jsonPath("$.data[0].name").value("JEANS"),
                        jsonPath("$.data[0].color").value("SAND BRUSH"),
                        jsonPath("$.data[1].name").value("T-SHIRTS"),
                        jsonPath("$.data[1].color").value("WHITE"));
    }

    @Test
    @DisplayName("상품이 없는 경우 상품 목록 조회에 실패한다")
    public void failToGetAllProducts() throws Exception {
        // given
        given(productService.getAllProducts()).willReturn(
                List.of());

        // when & then
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpectAll(
                        jsonPath("$.result").value("FAIL"));
    }
}
