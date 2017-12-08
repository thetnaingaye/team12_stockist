package team12.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team12.stockist.model.UsageRecordDetail;

public interface UsageRecordDetailRepository extends JpaRepository<UsageRecordDetail, Integer> {

}
