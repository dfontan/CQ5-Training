package com.accenture.cq5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.designer.Style;

public class ContextualFooter {
	
	private List<NavigationPage> footerPages;
	private String disclaimerText;
	
	public ContextualFooter(Page currentPage, Style currentStyle) {
		footerPages = generateFooterPages(currentPage);
		if (currentStyle != null ) { 
			setDisclaimerText(currentStyle.get("disclaimer","Set Disclaimer in Design mode"));
		}
	}
	
	private List<NavigationPage> generateFooterPages(Page currentPage) {
		List<NavigationPage> temp = new ArrayList<NavigationPage>();
		if (currentPage != null){
			Page parent = currentPage.getParent();
			if(parent != null) {
				Iterator<Page> children = parent.listChildren();
				while (children.hasNext()) {
					Page child = children.next();
					if (!currentPage.equals(child)) {
						NavigationPage np = new NavigationPage(child);
						temp.add(np);
					}
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
