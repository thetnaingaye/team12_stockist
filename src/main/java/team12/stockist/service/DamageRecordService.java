package team12.stockist.service;

import java.util.ArrayList;

import team12.stockist.model.DamageRecord;

public interface DamageRecordService {

	ArrayList<DamageRecord> findAllDamageRecord();

	DamageRecord findDamageRecordById(Integer rmaId);

	DamageRecord createDamageRecord(DamageRecord damageRecord);

	DamageRecord updateDamageRecord(DamageRecord damageRecord);

	void deleteDamageRecord(DamageRecord damageRecord);

}