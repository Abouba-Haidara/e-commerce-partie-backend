package com.gescom.gescom.web;

import com.gescom.gescom.entities.Product;
import com.gescom.gescom.models.ProductModel;
import com.gescom.gescom.services.CategoryService;
import com.gescom.gescom.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductRestController {
  final private ProductService productService;
  final private CategoryService categoryService;
    ProductRestController(
            final ProductService productService,
            final CategoryService categoryService
    ) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @PostMapping("/products")
  void createProduct(@RequestBody @Validated ProductModel productModel){
      Product product =  new Product();
      product.setTitle(productModel.getTitle());
      product.setCategory(this.categoryService.findOne(productModel.getCategoryId()));
      product.setPrice(productModel.getPrice());
      product.setCode(productModel.getCode());

     this.productService.createProduct(product);
  }

  @GetMapping("/products")
    List<Product> findAll() {
    return this.productService.findAll();
  }

  @DeleteMapping("/products/{id}")
  void deleteProduct(@PathVariable("id") long id) {
      this.productService.deleteProduct(id);
  }

    @DeleteMapping("/products")
    void deleteProduct() {
        this.productService.deleteProductAll();
    }


}
