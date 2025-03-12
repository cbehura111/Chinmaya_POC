package com.chinmaya.code.security.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Security Controller")
public class ProductController {
    private record Product(
            Integer productId,
            String productName,
            double price,
            String category
    ){}
    List<Product> products = new ArrayList<>(
            List.of(new Product(1, "Luxor Pen", 10.50, "stationary"),
                    new Product(2, "Samsung s23", 43050, "Phone"),
                    new Product(3, "Blue Bucket", 205, "Utility")
                    )
    );
    @GetMapping("/public/products")
    @ApiOperation(value = "get products detail", notes = "API to get products")
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a product to list of products", notes = "API add a product")
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }
//    @GetMapping("/public/csrf")
//    public CsrfToken getToken(HttpServletRequest request) {
//        return (CsrfToken) request.getAttribute("_csrf");
//    }
}
