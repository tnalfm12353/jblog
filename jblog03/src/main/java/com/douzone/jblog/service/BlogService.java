package com.douzone.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired 
	private CategoryRepository categoryRepository;
	
	public BlogVo getBlogInfo(UserVo authUser) {
		return blogRepository.getBlogInfo(authUser.getId());
	}
	
	public Map<String,Object> getblog(String id, Long categoryNo, Long postNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		BlogVo blogVo = blogRepository.getBlogInfo(id);
		List<CategoryVo> categoryList = categoryRepository.getCategories(id, true);
		map.put("blogInfo", blogVo);
		map.put("categoryList", categoryList);
		return map;
	}

	public void updateBlogInfo(UserVo authUser, BlogVo blogVo, String url) {
		blogVo.setUserId(authUser.getId());
		blogVo.setLogo(url);
		blogRepository.updateBlogInfo(blogVo);
	}

}
