package team12.stockist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team12.stockist.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
