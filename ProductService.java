package com.practice.PRODUCT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import java.awt.List;

import org.springframework.stereotype.Service;

import com.practice.PRODUCT.Entity.Product;
import com.practice.PRODUCT.Entity.product;
import com.practice.PRODUCT.Repository.ProductRepository;


@Service
public class ProductService {
	
@Autowired
private  ProductRepository productRepository;
 
// this readmethod
 
 public List<Product>  findAllProducts(){
	 
 List<Product> list= productRepository.findAll();
 return list;	  
 }
// this is createMethod
 public Product createProduct(Product product) {
	 return productRepository.save(product);	 
 }
 
// deleted methode
 public void deleteProduct(Long id) {
	 productRepository.deleteById(id);
 }
// updated method
 public Product updateProduct(Long id,Product product) {
     product.setId(id);
	 return productRepository.save(product);	 
 }
 
 
 

 
 
 
}
