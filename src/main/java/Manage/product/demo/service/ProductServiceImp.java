package Manage.product.demo.service;

import Manage.product.demo.ProductApplication;
import Manage.product.demo.model.Product;
import Manage.product.demo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImp(ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public Product updateProduct(Long id, Product newProductData) {
        Product existingProduct = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(newProductData.getName());
        existingProduct.setPrice(newProductData.getPrice());
        existingProduct.setQuantity(newProductData.getQuantity());
        return productRepo.save(existingProduct);
    }
    public void deleteProduct (Long id){
        productRepo.deleteById(id);
    }
    public List<Product> searchProductsByKeyword(String keyword) {
        return productRepo.searchByKeyword(keyword);
    }


}
