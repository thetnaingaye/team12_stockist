package team12.stockist.service;

import java.util.ArrayList;

import team12.stockist.model.UsageRecord;

public interface UsageRecordService {

	ArrayList<UsageRecord> findAllUsageRecord();

	UsageRecord findUsageRecordById(Integer Id);

	UsageRecord createUsageRecord(UsageRecord usageRecord);

	UsageRecord updateUsageRecord(UsageRecord usageRecord);

	void deleteUsageRecord(UsageRecord usageRecord);

}