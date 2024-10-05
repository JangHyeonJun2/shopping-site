package com.shoppingsite.shopppingsite;

import com.shoppingsite.shopppingsite.common.exception.EntityNotFoundException;
import com.shoppingsite.shopppingsite.domain.product.Product;

public class Fixtures {
    public static Product product(String name) {
        if (name.equals("JEANS")) {
            return Product.of(1L, "JEANS", "M", "SAND BRUSH", 97000, 50);
        }

        if (name.equals("T-SHIRTS")) {
            return Product.of(2L, "T-SHIRTS", "FREE", "WHITE", 49000, 37);
        }

        if (name.equals("CAP")) {
            return Product.of(3L, "CAP", "FREE", "GREEN", 49000, 8);
        }

        if (name.equals("PANTS")) {
            return Product.of(4L, "PANTS", "FREE", "PINK", 150000, 1);
        }

        if (name.equals("HOODIE")) {
            return Product.of(5L, "HOODIE", "L", "GREY", 109000, 15);
        }

        throw new EntityNotFoundException("찾는 상품이 없습니다. - name: " + name);
    }
}
