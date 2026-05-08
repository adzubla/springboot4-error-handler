package com.example.demo.product;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
class ProductController {

    private final ProductService service;

    ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse create(@RequestBody @Valid ProductRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    ProductResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
