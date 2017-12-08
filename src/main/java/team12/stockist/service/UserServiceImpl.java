package team12.stockist.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import team12.stockist.model.DamageRecord;
import team12.stockist.model.User;
import team12.stockist.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserRepository userRepository;
	
	@Override
	@Transactional
	public ArrayList<User> findAllUser(){
		ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
		return users;
		
	}

	@Override
	@Transactional
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}

	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
