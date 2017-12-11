package team12.stockist.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import team12.stockist.model.UsageRecord;

public interface UsageRecordRepository extends JpaRepository<UsageRecord, String> {
	
	// Native querry to retrieve data from usagerecords table based on passed
	// parameter products partId and join conditions

	@Query(value = "SELECT * from usagerecords ur,products p,usagerecorddetails urd  where p.PartID=?1 and p.PartID=urd.Products_PartID and urd.TransID=ur.TransID", nativeQuery = true)
	ArrayList<UsageRecord> findUsageRecordHistory(int products_PartID);
}
