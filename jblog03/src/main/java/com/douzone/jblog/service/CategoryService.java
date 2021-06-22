package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PostRepository postRepository;
	
	
	public List<CategoryVo> getCategories(UserVo userVo, boolean isSimple) {
		return categoryRepository.getCategories(userVo.getId(), isSimple);
	}

	public void insertCategory(UserVo authUser, CategoryVo categoryVo) {
		categoryVo.setUserId(authUser.getId());
		categoryRepository.insertCategory(categoryVo);
	}

	@Transactional
	public void deleteCategory(Long no, int postCount) {
		if(postCount > 0) {
			postRepository.deletePost(no);
		}
		categoryRepository.deleteCategory(no);
	}

}
