package team12.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import team12.stockist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	//Add repos
}
