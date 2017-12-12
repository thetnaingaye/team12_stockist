package team12.stockist.service;

import java.util.ArrayList;

import team12.stockist.model.UsageRecord;
import team12.stockist.model.User;

public interface UsageRecordService {

	ArrayList<UsageRecord> findAllUsageRecord();

	UsageRecord findUsageRecordById(String Id);

	UsageRecord createUsageRecord(UsageRecord usageRecord);

	UsageRecord updateUsageRecord(UsageRecord usageRecord);

	void deleteUsageRecord(UsageRecord usageRecord);

	ArrayList<UsageRecord> findUsageRecordHistory(int products_PartID);

	ArrayList<UsageRecord> findUsageRecordByUserId(int Id);

	boolean usageRecordisNotDeletable(User user);

	public ArrayList<UsageRecord> findUsageRecordHistoryByDate(int pid, String startdate, String enddate);

}