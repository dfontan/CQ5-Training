package com.accenture.cq5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.day.cq.wcm.api.Page;

public class NavigationPage {
	private String title;
	private String url;
	private List<NavigationPage> children;
	
	public NavigationPage(Page page) {
		this.title = findTitle(page);
		this.url = page.getPath();	
	}
	
	public NavigationPage(Page page, boolean findChildren) {
		this(page);
		this.children = findChildren(page);
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
	
	private List<NavigationPage> findChildren(Page parent) {
		List<NavigationPage> temp = new ArrayList<NavigationPage>();
		if (parent != null) {
			Iterator<Page> children = parent.listChildren();
			while (children.hasNext()) {
				NavigationPage np = new NavigationPage(children.next());
				temp.add(np);
			}
		}
		return temp;
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

	public List<NavigationPage> getChildren() {
		return children;
	}

	public void setChildren(List<NavigationPage> children) {
		this.children = children;
	}

}
