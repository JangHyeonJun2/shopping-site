package com.shoppingsite.shopppingsite.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/ecommerce")
    public String test() {
        return "ecommerce";
    }
}
