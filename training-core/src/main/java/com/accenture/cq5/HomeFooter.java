package com.accenture.cq5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.designer.Style;

public class HomeFooter {
	
	private List<NavigationPage> footerPages;
	private String disclaimerText;
	private ValueMap properties;
	private ResourceResolver resolver;
	private Style currentStyle;
	
	public HomeFooter(Resource resource, Style currentStyle) {
		this.properties = resource.adaptTo(ValueMap.class);
		this.resolver = resource.getResourceResolver();
		this.currentStyle = currentStyle;
		init();
	}
	
	private void init() {
		String url = "";
		if (properties != null) {
			url = properties.get("rootPage","");
		}
		footerPages = generateFooterPages(url);
		if (currentStyle != null) {
			setDisclaimerText(currentStyle.get("disclaimer","Set disclaimer in design"));
		}
	}
	
	private List<NavigationPage> generateFooterPages(String rootPage) {
		List<NavigationPage> temp = new ArrayList<NavigationPage>();
		if (rootPage != null && rootPage.equals("")){
			Page parent = resolver.getResource(rootPage).adaptTo(Page.class);
			if(parent != null) {
				Iterator<Page> children = parent.listChildren();
				while (children.hasNext()) {
					Page child = children.next();
					NavigationPage np = new NavigationPage(child);
					temp.add(np);
				}
			}
		}
		return temp;
	}

	public List<NavigationPage> getFooterPages() {
		return footerPages;
	}

	public void setFooterPages(List<NavigationPage> footerPages) {
		this.footerPages = footerPages;
	}

	public String getDisclaimerText() {
		return disclaimerText;
	}

	public void setDisclaimerText(String disclaimerText) {
		this.disclaimerText = disclaimerText;
	}

	

}
