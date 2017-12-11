package team12.stockist.repository;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import team12.stockist.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	
	@Query("SELECT p from Product p WHERE p.supplierID = :sId")
	ArrayList<Product> findProductBySupplier(@Param("sId") String supplierID);

}
