package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.PostVo;

@Repository
public class PostRepository {

	@Autowired
	private SqlSession session;

	public int getPostCount(Long no) {
		return session.selectOne("post.getPostCount", no);
	}

	public void deletePost(Long no) {
		session.delete("post.deleteAll", no);
	}

	public void insertPost(PostVo postVo) {
		session.insert("post.insert",postVo);
	}
}
