package com.douzone.jblog.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.security.Auth;
import com.douzone.jblog.security.AuthUser;
import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.FileUploadService;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private FileUploadService fileUploadService; 
	
	@RequestMapping({"", "/{categoryNo}" ,"/{categoryNo}/{postNo}"})
	public String index(@PathVariable("id") String id,
						@PathVariable("categoryNo") Optional<Long> pathNo1,
						@PathVariable("postNo") Optional<Long> pathNo2, Model model) {
		Long categoryNo = 0L;
		Long postNo = 0L;
		
		if(pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
		} else if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
		}
		System.out.println("id:" + id);
		System.out.println("pathNo1:" + pathNo1);
		System.out.println("pathNo2:" + pathNo2);
		
		Map<String, Object> map = blogService.getblog(id,categoryNo,postNo);
		model.addAttribute("map", map);
		
		return "blog/index";
	}
	
	@Auth
	@RequestMapping("/admin/basic")
	public String adminBasic(@AuthUser UserVo authUser, Model model) {
		model.addAttribute("blogInfo", blogService.getBlogInfo(authUser));
		return "blog/admin/basic";
	}
	
	@Auth
	@PostMapping("/admin/basic")
	public String adminBasic(@AuthUser UserVo authUser, @Valid BlogVo blogVo, MultipartFile logofile, BindingResult result) {
		//TODO: blogvo title에 어떠한 값도 없을때 400에러 발생 --> 그냥 블로그로 이동하게 하기.
		if(!result.hasErrors()) {
			blogService.updateBlogInfo(authUser,blogVo,fileUploadService.restore(logofile));
		}
		return "redirect:/"+authUser.getId();
	}

	
	@Auth
	@RequestMapping("/admin/category")
	public String adminCategory() {
		return "blog/admin/category";
	}
	
	@Auth
	@RequestMapping("/admin/write")
	public String adminWrite() {
		return "blog/admin/write";
	}
	
}
