package ru.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shop.model.Product;
import ru.shop.model.ProductReturn;
import ru.shop.model.ProductType;
import ru.shop.service.ProductReturnService;
import ru.shop.service.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productReturn")
public class ProductReturnController {
    private final ProductReturnService productReturnService;

    @GetMapping
    public List<ProductReturn> getAll() {
        return productReturnService.findAll();
    }

//    @PostMapping
//    public void save(@RequestBody ProductReturn productReturn) {
//        productReturnService.save(productReturn);
//    }

    @GetMapping("/{id}")
    public ProductReturn getById(@PathVariable UUID id) {
        return productReturnService.findById(id);
    }


}
