package team12.stockist.service;

import java.util.ArrayList;

import team12.stockist.model.UsageRecord;

public interface UsageRecordService {

	ArrayList<UsageRecord> findAllUsageRecord();

	UsageRecord findUsageRecordById(String Id);

	UsageRecord createUsageRecord(UsageRecord usageRecord);

	UsageRecord updateUsageRecord(UsageRecord usageRecord);

	void deleteUsageRecord(UsageRecord usageRecord);

	public ArrayList<UsageRecord> findUsageRecordHistory(int products_PartID);
	
	
	public ArrayList<UsageRecord> findUsageRecordHistoryByDate(int pid, String startdate, String enddate);

}