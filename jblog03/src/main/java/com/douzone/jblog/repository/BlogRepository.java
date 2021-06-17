package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public void createBlog(UserVo userVo) {
		sqlSession.insert("blog.insert", userVo);
	}

	public BlogVo getBlogInfo(String id) {
		return sqlSession.selectOne("blog.getBlogInfo",id);
		
	}

	public void updateBlogInfo(BlogVo blogVo) {
		sqlSession.update("blog.updateBlogInfo",blogVo);
		
	}

}
