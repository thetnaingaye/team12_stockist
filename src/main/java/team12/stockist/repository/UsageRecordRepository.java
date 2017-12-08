package team12.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team12.stockist.model.UsageRecord;

public interface UsageRecordRepository extends JpaRepository<UsageRecord, Integer> 
{

}
