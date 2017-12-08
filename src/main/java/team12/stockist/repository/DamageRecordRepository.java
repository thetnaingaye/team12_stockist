package team12.stockist.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import team12.stockist.model.DamageRecord;;


public interface DamageRecordRepository extends JpaRepository<DamageRecord,Integer>
{

}
