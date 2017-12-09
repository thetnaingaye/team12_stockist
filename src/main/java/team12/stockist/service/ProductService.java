package team12.stockist.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import team12.stockist.model.Product;

public interface ProductService 
{

	ArrayList<Product> findAllProduct();
	
	Product findProductById(Integer productId);
	
	Product createProduct(Product product);
	
	Product updateProduct(Product product);
	
	void deleteProduct(Product product);
}