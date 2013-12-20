package com.accenture.cq5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.day.cq.wcm.api.Page;


public class TopNav {
	
	private Page currentPage;
	private List<NavigationPage> navNodes;
	
	public TopNav(Page currentPage) {
		this.currentPage = currentPage;
		init();
		
	}
	
	private void init() {
		if (currentPage != null) {
			Page rootPage = currentPage.getAbsoluteParent(1);
			this.navNodes = findNavNodes(rootPage);	
		}	
	}
	
	private List<NavigationPage> findNavNodes(Page root) {
		List<NavigationPage> temp = new ArrayList<NavigationPage>();
		if (root != null) {
			Iterator<Page> children = root.listChildren();
			while (children.hasNext()) {
				NavigationPage np = new NavigationPage(children.next(), true);
				temp.add(np);
			}		
		}
		
		return temp;
	}

	public List<NavigationPage> getNavNodes() {
		return navNodes;
	}

	public void setNavNodes(List<NavigationPage> navNodes) {
		this.navNodes = navNodes;
	}

}
