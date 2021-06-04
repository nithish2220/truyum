package com.cognizant.truyum.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {

	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> l = new ArrayList<>();
		try {
			Connection con = ConnectionHandler.getConnection();
			String s = "select * from menu_item;";
			PreparedStatement p = con.prepareStatement(s);
			ResultSet r = p.executeQuery();
			while(r.next()) {
				long id = (long)r.getInt("id");
				String name = r.getString("name");
				float price = r.getFloat("price");
				String x = r.getString("active");
				boolean active = (x.equalsIgnoreCase("Yes")) ? true : false;
				String dateOfLaunch = r.getString("dateOfLaunch");
				String category = r.getString("category");
				String y = r.getString("freeDelivery");
				boolean freeDelivery = (y.equalsIgnoreCase("Yes")) ? true : false;
				MenuItem m = new MenuItem(id,name,price,active,DateUtil.convertToDateDB(dateOfLaunch),category,freeDelivery);
				l.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> l = new ArrayList<>();
		try {
			Connection con = ConnectionHandler.getConnection();
			String s = "select * from menu_item where active = 'Yes' and dateOfLaunch <= CURDATE();";
			PreparedStatement p = con.prepareStatement(s);
			ResultSet r = p.executeQuery();
			while(r.next()) {
				long id = (long)r.getInt("id");
				String name = r.getString("name");
				float price = r.getFloat("price");
				String x = r.getString("active");
				boolean active = (x.equalsIgnoreCase("yes")) ? true : false;
				String dateOfLaunch = r.getString("dateOfLaunch");
				String category = r.getString("category");
				String y = r.getString("freeDelivery");
				boolean freeDelivery = (y.equalsIgnoreCase("yes")) ? true : false;
				MenuItem m = new MenuItem(id,name,price,active,DateUtil.convertToDateDB(dateOfLaunch),category,freeDelivery);
				l.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		try {
			Connection con = ConnectionHandler.getConnection();
			String s = "select * from menu_item where id = "+menuItemId+";";
			PreparedStatement p = con.prepareStatement(s);
			ResultSet r = p.executeQuery();
			while(r.next()) {
				long id = (long)r.getInt("id");
				String name = r.getString("name");
				float price = r.getFloat("price");
				String x = r.getString("active");
				boolean active = (x.equalsIgnoreCase("yes")) ? true : false;
				String dateOfLaunch = r.getString("dateOfLaunch");
				String category = r.getString("category");
				String y = r.getString("freeDelivery");
				boolean freeDelivery = (y.equalsIgnoreCase("yes")) ? true : false;
				MenuItem m = new MenuItem(id,name,price,active,DateUtil.convertToDateDB(dateOfLaunch),category,freeDelivery);
				return m;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void editMenuItem(MenuItem menuItem){
		try {
			Connection con = ConnectionHandler.getConnection();
			System.out.println(menuItem);
			String s = "update menu_item set name=?, price=?, active=?, dateOfLaunch=?, category=?, freeDelivery=? where id=?;";
			PreparedStatement p = con.prepareStatement(s);
			p.setString(1,menuItem.getName());
			p.setFloat(2,menuItem.getPrice());
			boolean x = menuItem.isActive();
			String active = (x) ? "Yes" : "No";
			p.setString(3,active);
			Date d =  menuItem.getDateOfLaunch();
			java.sql.Date e = new java.sql.Date(d.getTime());
			p.setDate(4,e);
			p.setString(5,menuItem.getCategory());
			boolean y = menuItem.isFreeDelivery();
			String freeDelivery = (y) ? "Yes" : "No";
			p.setString(6,freeDelivery);
			p.setInt(7,(int)menuItem.getId());
			p.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}