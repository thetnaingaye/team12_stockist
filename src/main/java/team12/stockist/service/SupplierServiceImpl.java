package team12.stockist.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team12.stockist.model.Supplier;
import team12.stockist.repository.SupplierRepository;


@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Resource
	SupplierRepository supplierRepository;
	
	/* (non-Javadoc)
	 * @see team12.stockist.service.SupplierService#findAllDamageRecord()
	 */
	@Override
	@Transactional
	public ArrayList<Supplier> findAllDamageRecord(){
		ArrayList<Supplier> supplierList = (ArrayList<Supplier>) supplierRepository.findAll();
		return supplierList;
	}
	

	/* (non-Javadoc)
	 * @see team12.stockist.service.SupplierService#findSupplierById(java.lang.String)
	 */
	@Override
	@Transactional
	public Supplier findSupplierById(String supplierId) {
		return supplierRepository.findOne(supplierId);
	}

	/* (non-Javadoc)
	 * @see team12.stockist.service.SupplierService#createSupplierRecord(team12.stockist.model.Supplier)
	 */
	@Override
	@Transactional
	public Supplier createSupplierRecord(Supplier supplier) {
		return supplierRepository.saveAndFlush(supplier);
	}

	/* (non-Javadoc)
	 * @see team12.stockist.service.SupplierService#updateSupplierRecord(team12.stockist.model.Supplier)
	 */
	@Override
	@Transactional
	public Supplier updateSupplierRecord(Supplier supplier) {
		return supplierRepository.saveAndFlush(supplier);
	}

	/* (non-Javadoc)
	 * @see team12.stockist.service.SupplierService#deleteSupplierRecord(team12.stockist.model.Supplier)
	 */
	@Override
	@Transactional
	public void deleteSupplierRecord(Supplier supplier) {
		supplierRepository.delete(supplier);
	}

}
