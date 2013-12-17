package com.accenture.cq5;

import com.day.cq.wcm.api.Page;

public class NavigationPage {
	private String title;
	private String url;
	
	public NavigationPage(Page page) {
		this.title = findTitle(page);
		this.url = page.getPath();
		
	}
	
	private String findTitle(Page page) {
		String title = "";
		if (page.getTitle() != null) {
			title = page.getTitle();
		} else if (page.getPageTitle() != null) {
			title = page.getPageTitle();
		} else {
			title = page.getName();
		}
		return title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
