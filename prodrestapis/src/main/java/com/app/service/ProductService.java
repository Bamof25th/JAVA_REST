package com.app.service;

import java.util.List;

import com.app.entites.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long pid);

	String updateProduct(Long pid, int qty, Double price);

	String deleteProduct(Long pid);

	String addNewProduct(Product newProduct);

}
