package team12.stockist.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team12.stockist.model.DamageRecord;
import team12.stockist.repository.DamageRecordRepository;

@Service
public class DamageRecordServiceImpl implements DamageRecordService {
	
	@Resource
	DamageRecordRepository damageRecordRepository;
	
	//Write basic CRUD functions
	
	/* (non-Javadoc)
	 * @see team12.stockist.service.DamageRecordService#findAllDamageRecord()
	 */
	@Override
	@Transactional //List all
	public ArrayList<DamageRecord> findAllDamageRecord(){
		ArrayList<DamageRecord> damageRecordsList = (ArrayList<DamageRecord>)damageRecordRepository.findAll();
		return damageRecordsList;
	}
	
	/* (non-Javadoc)
	 * @see team12.stockist.service.DamageRecordService#findDamageRecordById(java.lang.Integer)
	 */
	@Override
	@Transactional //Retrival of Single Record
	public DamageRecord findDamageRecordById (Integer rmaId) {
		return damageRecordRepository.findOne(rmaId);
	}
	
	/* (non-Javadoc)
	 * @see team12.stockist.service.DamageRecordService#createDamageRecord(team12.stockist.model.DamageRecord)
	 */
	@Override
	@Transactional //Create a new record
	public DamageRecord createDamageRecord(DamageRecord damageRecord) {
		return damageRecordRepository.saveAndFlush(damageRecord);
	
	}
	
	/* (non-Javadoc)
	 * @see team12.stockist.service.DamageRecordService#updateDamageRecord(team12.stockist.model.DamageRecord)
	 */
	@Override
	@Transactional //update existing record by passing in an model object
	public DamageRecord updateDamageRecord(DamageRecord damageRecord) {
		return damageRecordRepository.saveAndFlush(damageRecord);
	}
	
	/* (non-Javadoc)
	 * @see team12.stockist.service.DamageRecordService#deleteDamageRecord(team12.stockist.model.DamageRecord)
	 */
	@Override
	@Transactional //remove a record reference by model object
	public void deleteDamageRecord(DamageRecord damageRecord) {
		damageRecordRepository.delete(damageRecord);
	}

}
