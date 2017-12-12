package team12.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import team12.stockist.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u from User u WHERE u.username = :username")
	public User findByUserName(@Param("username") String username);

	@Query("SELECT u.userRole from User u WHERE u.username = :username")
	public List<String> findRoleByUserName(@Param("username") String username);




}
