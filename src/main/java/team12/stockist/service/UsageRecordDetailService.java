package team12.stockist.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import team12.stockist.controller.SearchUsageRecord;
import team12.stockist.model.UsageRecordDetail;

public interface UsageRecordDetailService {

	ArrayList<UsageRecordDetail> findAllUsageRecordDetail();

	UsageRecordDetail findUsageRecordDetailById(Integer id);

	UsageRecordDetail createUsageRecordDetail(UsageRecordDetail usageRecordDetail);

	UsageRecordDetail updateUsageRecordDetail(UsageRecordDetail usageRecordDetail);
	
	ArrayList<UsageRecordDetail> addUsageRecordDetailList(ArrayList<UsageRecordDetail> usageRecordDetails);

	public ArrayList<UsageRecordDetail> findTransactionHistoryByProductId(int products_PartID);
	
	
	
	public ArrayList<UsageRecordDetail> findTransactionHistoryByDateRange(int products_PartID,Date startDate,Date endDate);


}



	

