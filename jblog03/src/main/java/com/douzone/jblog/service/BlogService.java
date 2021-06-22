package com.douzone.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;
import com.douzone.jblog.vo.UserVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired 
	private CategoryRepository categoryRepository;
	@Autowired
	private PostRepository postRepository;
	
	public BlogVo getBlogInfo(UserVo authUser) {
		return blogRepository.getBlogInfo(authUser.getId());
	}
	
	public Map<String,Object> getblog(String id, Long categoryNo, Long postNo) {
		
		BlogVo blogVo = blogRepository.getBlogInfo(id);
		
		List<CategoryVo> categoryList = categoryRepository.getCategories(id, true);
		if(categoryNo == 0L) {
			categoryNo = categoryList.get(0).getNo();
		}
		
		List<PostVo> postList = postRepository.getPostList(categoryNo);
		if(postNo == 0L && postList.size() > 0) {
			postNo = postList.get(0).getNo();
		}
		
		PostVo post = postRepository.getPost(postNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogInfo", blogVo);
		map.put("categoryList", categoryList);
		map.put("postList", postList);
		map.put("post", post);
		return map;
	}

	public void updateBlogInfo(UserVo authUser, BlogVo blogVo, String url) {
		blogVo.setUserId(authUser.getId());
		blogVo.setLogo(url);
		blogRepository.updateBlogInfo(blogVo);
	}
}
