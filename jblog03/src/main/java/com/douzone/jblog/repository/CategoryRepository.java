package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;

@Repository
public class CategoryRepository {
	
	@Autowired
	private SqlSession session;
	
	public List<CategoryVo> getCategories (String id, boolean isSimple){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("isSimple", isSimple);
		List<CategoryVo> list = session.selectList("category.findAll", map);
		System.out.println(list);
		return list;
	}

	public void insertCategory(CategoryVo categoryVo) {
		session.insert("category.insert",categoryVo);
	}

	public void deleteCategory(Long no) {
		session.delete("category.delete",no);
	}
}
