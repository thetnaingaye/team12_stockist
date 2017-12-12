package team12.stockist.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import team12.stockist.controller.SearchUsageRecord;
import team12.stockist.model.UsageRecordDetail;

public interface UsageRecordDetailRepository extends JpaRepository<UsageRecordDetail, Integer> {
	
	// Native querry to retrieve data from usagerecorddetails table based on
	// products partid and join conditions
	@Query(value = "SELECT * \r\n"
			+ "from products p,usagerecorddetails urd,usagerecords ur where p.PartID=?1 and p.PartID=urd.Products_PartID and urd.TransID=ur.TransID", nativeQuery = true)
	ArrayList<UsageRecordDetail> findTransactionHistoryByProductId(int products_PartID);

/*@Query (value="SELECT *  from products p,usagerecorddetails urd,usagerecords ur where p.PartID=?1 and p.PartID=urd.Products_PartID and urd.TransID=ur.TransID and ur.DateUsed between ?2 and ?3",nativeQuery = true )
//ArrayList<SearchUsageRecord> findTransactionHistoryByDateRange(int products_PartID,Date startDate,Date endDate);
ArrayList<UsageRecordDetail> findTransactionHistoryByDateRange(int products_PartID,Date startDate,Date endDate);*/


@Query (value="SELECT *  from products p,usagerecorddetails urd,usagerecords ur where p.PartID=123 and \r\n" + 
		"p.PartID=urd.Products_PartID and urd.TransID=ur.TransID and\r\n" + 
		" ur.DateUsed between '2000-07-01' and '2018-07-01'",nativeQuery = true )
ArrayList<UsageRecordDetail> findTransactionHistoryByDateRange();



}

