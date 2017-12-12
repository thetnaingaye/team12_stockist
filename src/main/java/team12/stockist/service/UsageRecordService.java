package team12.stockist.service;

import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;

import team12.stockist.controller.Cart;
import team12.stockist.controller.CartItem;
import team12.stockist.model.UsageRecord;
import team12.stockist.model.UsageRecordDetail;

public interface UsageRecordService {

	ArrayList<UsageRecord> findAllUsageRecord();

	UsageRecord findUsageRecordById(String Id);

	UsageRecord createUsageRecord(UsageRecord usageRecord);

	UsageRecord updateUsageRecord(UsageRecord usageRecord);

	void deleteUsageRecord(UsageRecord usageRecord);

	public ArrayList<UsageRecord> findUsageRecordHistory(int products_PartID);
	
	public ArrayList<UsageRecord> findUsageRecordHistoryByDate(int pid, String startdate, String enddate);

	ArrayList<CartItem> checkStockAvailable(Cart cart);

	ArrayList<UsageRecordDetail> checkoutCartDetails(Cart cart);

}