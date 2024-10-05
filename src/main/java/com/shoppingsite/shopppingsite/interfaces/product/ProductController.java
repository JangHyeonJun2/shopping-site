package com.shoppingsite.shopppingsite.interfaces.product;

import com.shoppingsite.shopppingsite.domain.product.ProductService;
import com.shoppingsite.shopppingsite.common.response.CommonResponse;
import com.shoppingsite.shopppingsite.common.response.ErrorCode;
import com.shoppingsite.shopppingsite.domain.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Tag(name = "상품 목록 조회 API", description = "등록된 전체 상품 목록을 조회합니다")
    @GetMapping
    public CommonResponse<List<Product>> getALlProducts() {
        try {
            List<Product> result = productService.getAllProducts();
            if (result.isEmpty()) {
                return CommonResponse.fail("등록된 상품이 없습니다.", ErrorCode.COMMON_ENTITY_NOT_FOUND.toString());
            }
            return CommonResponse.success(result);
        } catch (Exception e) {
            return CommonResponse.fail("상품 목록 조회에 실패했습니다.", ErrorCode.COMMON_SYSTEM_ERROR.toString());
        }

    }
}