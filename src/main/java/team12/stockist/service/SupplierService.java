package team12.stockist.service;

import java.util.ArrayList;

import team12.stockist.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> findAllSupplier();

	Supplier findSupplierById(String supplierId);

	Supplier createSupplierRecord(Supplier supplier);

	Supplier updateSupplierRecord(Supplier supplier);

	void deleteSupplierRecord(Supplier supplier);

}