package com.douzone.jblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.jblog.dto.JsonResult;
import com.douzone.jblog.security.Auth;
import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.CategoryService;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@RestController("BlogControllerApi")
@RequestMapping("/{id:(?!assets).*}/admin/api")
public class BlogController {

	@Autowired
	private CategoryService categoryService;
	
	@Auth
	@GetMapping("/category")
	public JsonResult categoryList(@AuthUser UserVo authUser ) {
		return JsonResult.success(categoryService.getCategories(authUser, false));
	}
	
	@Auth
	@PostMapping("/category")
	public JsonResult insertCategory(@AuthUser UserVo authUser,@RequestBody CategoryVo categoryVo) {
		
		categoryService.insertCategory(authUser,categoryVo);
		return JsonResult.success(categoryVo);
	}
	
	@Auth
	@DeleteMapping("/category/delete/{no}/{postCount}")
	public JsonResult deleteCategory(@AuthUser UserVo authUser, @PathVariable Long no, @PathVariable int postCount) {
		categoryService.deleteCategory(no, postCount);
		return JsonResult.success(no);
	}
}
