package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	
	// TODO:transactional Rollback 안댐. xmlns:tx="http://www.springframework.org/schema/tx"
	@Transactional
	public void userJoin(UserVo userVo) {
		if(userRepository.userJoin(userVo)) {
			blogRepository.createBlog(userVo);
		}
	}

	public UserVo login(String id, String password) {
		return userRepository.login(id,password);
	}

}
