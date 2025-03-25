package Manage.product.demo.controller;

import Manage.product.demo.model.Product;
import Manage.product.demo.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductServiceImp productServiceImp;

    @Autowired
    public ProductController(ProductServiceImp productServiceImp) {
        this.productServiceImp = productServiceImp;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productServiceImp.getAllProducts() ;
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productServiceImp.getProductById(id);
    }
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return productServiceImp.saveProduct(product);

    }
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productServiceImp.updateProduct(id, product);
    }
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){
        productServiceImp.deleteProduct(id);
        return "the product " + id + " is deleted";
    }
    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productServiceImp.searchProductsByKeyword(keyword);
    }


}
