package team12.stockist.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import team12.stockist.model.Product;
import team12.stockist.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductRepository prepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see team12.stockist.service.ProductService#findAllProduct()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProduct() {
		ArrayList<Product> sl = (ArrayList<Product>) prepo.findAll();
		return sl;
	}

	@Override
	@Transactional
	public Product findProductById(Integer productId) {
		return prepo.findOne(productId);
	}

	@Override
	@Transactional
	public Product createProduct(Product product) {
		return prepo.saveAndFlush(product);
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		return prepo.saveAndFlush(product);
	}

	@Override
	@Transactional
	public void deleteProduct(Product product) {
		prepo.delete(product);

	}

}
