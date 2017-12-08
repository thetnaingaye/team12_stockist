package team12.stockist.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import team12.stockist.model.Product;

public interface ProductService {

	ArrayList<Product> findAllProduct();

}