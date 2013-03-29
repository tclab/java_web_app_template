package com.artica.administrator.fc;

import java.util.ArrayList;

import com.artica.administrator.bo.menuBO.MenuItem;
import com.artica.administrator.dao.menuDAO.MenuDAO;

public class MenuHandler {

	/**
	 * Processes the menu of a section.
	 * @param sectionName
	 * @return
	 */
	public ArrayList<MenuItem> processMenu(String sectionName){
		
		ArrayList<MenuItem> itemsBySection = new MenuDAO().getMenuItems(sectionName);
		for (MenuItem menuItem : itemsBySection) {
			menuItem = getChilds(menuItem);
		}
		return itemsBySection;
	}
	
	/**
	 * Sets child nodes of the given menu item.
	 * @param menuItem
	 * @return
	 */
	public MenuItem getChilds(MenuItem menuItem){
		ArrayList<MenuItem> childs = new MenuDAO().getChilds(menuItem.getCode());
		if (childs.size() != 0) {
			menuItem.setChildItems(childs);
			
			for (MenuItem childNode : childs) {
				childNode = getChilds(childNode);
			}
		}
		return menuItem;
	}
}
