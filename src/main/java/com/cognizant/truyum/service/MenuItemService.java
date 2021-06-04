package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	
	@Autowired
	MenuItemDaoSqlImpl ob;
	
	public List<MenuItem> getMenuItemListAdmin() {
		
		List<MenuItem> menuItemListAdmin = ob.getMenuItemListAdmin();	
		return menuItemListAdmin;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCustomer = ob.getMenuItemListCustomer();
		return menuItemListCustomer;
	}

	public MenuItem getMenuItem(int id) {
		MenuItem menuItem = ob.getMenuItem(id);
		return menuItem;
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		ob.editMenuItem(menuItem);
	}
}
