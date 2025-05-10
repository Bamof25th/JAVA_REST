package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourcesNotFound;
import com.app.dao.ProductDao;
import com.app.entites.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public String updateProduct(Long pid, int qty, Double price) {

		Product p = productDao.findById(pid).orElseThrow(() -> new ResourcesNotFound("Product not found"));
		p.setAvailableQuantity(qty);
		p.setPrice(price);

		productDao.save(p);

		return "Product updated SucessFully";
	}

	@Override
	public Product getProductById(Long pid) {

		Product p = productDao.findById(pid).orElseThrow(() -> new ResourcesNotFound("Product not found"));

		return p;
	}

	@Override
	public String deleteProduct(Long pid) {

		productDao.deleteById(pid);

		return "Deleted SuccessFully";
	}

	@Override
	public String addNewProduct(Product newProduct) {
		if (productDao.getProductByName(newProduct.getName()).isEmpty()) {
			productDao.save(newProduct);
			return "Product Added Successfully";
		} else {
			// throw new ApiException("Dup restaurant name !!!!!!");
			return "Product is already present with the same name";
		}

	}

}
