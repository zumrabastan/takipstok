package com.stok.takipstok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        }).orElseGet(() -> {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        });
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    
    @GetMapping("/wrapped")
public ResponseWrapper<List<Product>> getWrappedProducts() {
    List<Product> products = productRepository.findAll();
    return new ResponseWrapper<>("Ürünler başarıyla getirildi", products);
}
@GetMapping("/filtered")
public List<Product> getFilteredProducts(@RequestParam int minQuantity) {
    return productRepository.findAll()
            .stream()
            .filter(p -> p.getQuantity() >= minQuantity)
            .toList();
}

    
}
