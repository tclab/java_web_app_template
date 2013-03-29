package com.artica.administrator.bo.menuBO;

import java.util.ArrayList;

public class MenuItem {
	
	private String section;
	private String name;
	private String url;
	private String parent;
	private String order;
	private String code;
	private ArrayList<MenuItem> childItems;
	
	
	public MenuItem(){
		
	}
	
	public MenuItem(String section, String name, String url, String parent, String order, String code){
		this.section = section;
		this.name = name;
		this.url = url;
		this.parent = parent;
		this.order = order;
		this.code = code;
	}
	
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public ArrayList<MenuItem> getChildItems() {
		return childItems;
	}
	public void setChildItems(ArrayList<MenuItem> childItems) {
		this.childItems = childItems;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
