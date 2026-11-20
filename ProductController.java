package com.practice.PRODUCT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.PRODUCT.Entity.Product;
import com.practice.PRODUCT.Entity.product;
import com.practice.PRODUCT.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productservice;

	
//	read
    @GetMapping("/read")
    public List<Product> getAll(Product product){
    	return productservice.findAllProducts();
    }
    
//    create
    @PostMapping("/create")
    public Product create(@RequestBody Product product)
    {
    	return productservice.createProduct(product);
    }
    
    
    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
    	
    	productservice.deleteProduct(id);
    	return "product deleted";
    }
    
    @PutMapping("{id}")
    public Product Updated(@RequestBody Product product, @PathVariable Long id) {
    	product.setId(id);
    	return productservice.updateProduct( id, product);
    }
}
