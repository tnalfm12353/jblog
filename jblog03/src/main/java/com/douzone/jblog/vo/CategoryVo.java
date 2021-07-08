package com.douzone.jblog.vo;


public class CategoryVo {

	private Long no;
	private String name;
	private String description;
	private String regDate;
	private String userId;
	
	
	private String blogTitle;
	private Integer postCount = 0;
	
	public CategoryVo() {
	}
	
	public CategoryVo(String name, String description, String userId) {
		this.name = name;
		this.description = description;
		this.userId = userId;
	}
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(Integer postCount) {
		this.postCount = postCount;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", description=" + description + ", regDate=" + regDate + ", userId="
				+ userId + ", blogTitle=" + blogTitle + ", postCount=" + postCount + "]";
	}
}
