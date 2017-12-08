package team12.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team12.stockist.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, String> {

}
