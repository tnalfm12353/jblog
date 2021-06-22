package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	// TODO:transactional Rollback 안댐. xmlns:tx="http://www.springframework.org/schema/tx"
	@Transactional
	public void userJoin(UserVo userVo) {
		if(userRepository.userJoin(userVo)) {
			if(blogRepository.createBlog(userVo)) {
				CategoryVo categoryVo = new CategoryVo("전체","카테고리 상관없이 모든 게시물을 가져오는 카테고리",userVo.getId());
				categoryRepository.insertCategory(categoryVo);
			}
		}
	}

	public UserVo login(String id, String password) {
		return userRepository.login(id,password);
	}

	public UserVo getUser(String id) {
		return userRepository.findById(id);
	}

}
