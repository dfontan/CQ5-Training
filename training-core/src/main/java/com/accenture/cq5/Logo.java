package com.accenture.cq5;

import org.apache.sling.api.resource.Resource;

import com.day.cq.wcm.api.designer.Style;
import com.day.cq.wcm.foundation.Image;

public class Logo {
	
	private Resource res;
	private Image logoImage;
	private boolean noImage = false;
	
	public Logo(Style currentStyle) {
		if (currentStyle != null) {
			this.res = currentStyle.getDefiningResource("fileReference");
			if (res == null) {
				currentStyle.getDefiningResource("file");
			}
			
			if (res == null) {
				noImage = true;
			} else {
				logoImage = new Image(res);
				if (logoImage.hasContent()) {
					logoImage.setSelector(".img");
				}
			}
		} else {
			noImage = true;
		}	
	}

	public Image getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(Image logoImage) {
		this.logoImage = logoImage;
	}

	public boolean isNoImage() {
		return noImage;
	}

	public void setNoImage(boolean noImage) {
		this.noImage = noImage;
	}

}
