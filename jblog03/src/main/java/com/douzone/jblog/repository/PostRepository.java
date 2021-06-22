package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.PostVo;

@Repository
public class PostRepository {

	@Autowired
	private SqlSession session;

	public void deletePost(Long no) {
		session.delete("post.deleteAll", no);
	}

	public void insertPost(PostVo postVo) {
		session.insert("post.insert",postVo);
	}

	public List<PostVo> getPostList(Long categoryNo) {
		return session.selectList("post.getPostList", categoryNo);
	}

	public PostVo getPost(Long postNo) {
		return session.selectOne("post.getPost", postNo);
	}
}
