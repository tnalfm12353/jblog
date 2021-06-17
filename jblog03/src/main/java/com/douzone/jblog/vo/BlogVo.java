package com.douzone.jblog.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BlogVo {
	
	private String userId;
	@NotEmpty @NotNull
	private String title;
	private String logo;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getLogo() {
		return logo;
	}

	@Override
	public String toString() {
		return "BlogVo [userId=" + userId + ", title=" + title + ", logo=" + logo + "]";
	}
}
