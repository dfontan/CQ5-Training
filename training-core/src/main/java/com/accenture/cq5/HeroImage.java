package com.accenture.cq5;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import com.day.cq.wcm.foundation.Image;

public class HeroImage {
	
	/* Hero Properties */
	private Image image;
	private String imageTitle;
	private String color;
	private String imageDescription;
	
	/* Props */
	private ValueMap properties;
	private Resource resource;
	
	public HeroImage(Resource resource) {
		this.resource = resource;
		properties = resource.adaptTo(ValueMap.class);
		init();
	}
	
	private void init() {
		image = new Image(resource, "image");
		if (image.hasContent()){
			image.setSelector(".img");
		}
		
		if(properties != null) {
			setImageTitle(properties.get("imageTitle",""));
			setImageDescription(properties.get("imageDescription",""));
			setColor(properties.get("color",""));
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

}
