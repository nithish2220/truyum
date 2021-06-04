/*package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String args[]) {
		//MenuItemDaoSqlImplTest.testGetMenuItemListAdmin();
		//MenuItemDaoSqlImplTest.testGetMenuItemListCustomer();
		//MenuItemDaoSqlImplTest.testModifyMenuItem();
		//MenuItemDaoSqlImplTest.testGetMenuItem();
		MenuItemDaoSqlImplTest.testGetMenuItemListAdmin();
	}

	static void testGetMenuItemListAdmin() {
		 MenuItemDaoSqlImpl m = new  MenuItemDaoSqlImpl();
		 List<MenuItem> l = m.getMenuItemListAdmin();
		 for(int i=0;i<l.size();i++) System.out.println(l.get(i));
	}

	static void testGetMenuItemListCustomer() {
		MenuItemDaoSqlImpl m = new  MenuItemDaoSqlImpl();
		 List<MenuItem> l = m.getMenuItemListCustomer();
		 for(int i=0;i<l.size();i++) System.out.println(l.get(i));
	}

	static void testModifyMenuItem() {
		MenuItemDaoSqlImpl m = new  MenuItemDaoSqlImpl();
		MenuItem m5 = new MenuItem((long)5,"Chocolate Brownie",33.00f,true,DateUtil.convertToDate("02/11/2022"),"Dessert",true);
		m.editMenuItem(m5);
	}

	static void testGetMenuItem() {
		MenuItemDaoSqlImpl m = new  MenuItemDaoSqlImpl();
		MenuItem a = m.getMenuItem(5);
		System.out.println(a);
	}

}
*/