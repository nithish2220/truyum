package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		try {
			Connection con = ConnectionHandler.getConnection();
			String s = "insert into cart values(?,?);";
			PreparedStatement p = con.prepareStatement(s);
			p.setInt(1,(int)userId);
			p.setInt(2,(int)menuItemId);
			p.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		List<MenuItem> l = new ArrayList<>();
		try {
			Connection con = ConnectionHandler.getConnection();
			Cart c = new Cart(l,0);
			String s = "select m.id, m.name, m.price, m.active, m.dateOfLaunch, m.category, m.freeDelivery from menu_item as m " + 
					"JOIN cart as c " + 
					"on m.id = c.menuItemId " + 
					"where c.userId = ?;";
			PreparedStatement p1 = con.prepareStatement(s);
			p1.setInt(1,(int)userId);
			ResultSet r = p1.executeQuery();
			while(r.next()) {
				long id = (long)r.getInt(1);
				String name = r.getString(2);
				float price = r.getFloat(3);
				String x = r.getString(4);
				boolean active = (x.equalsIgnoreCase("y")) ? true : false;
				String dateOfLaunch = r.getString(5);
				String category = r.getString(6);
				String y = r.getString(7);
				boolean freeDelivery = (y.equalsIgnoreCase("y")) ? true : false;
				MenuItem m = new MenuItem(id,name,price,active,DateUtil.convertToDateDB(dateOfLaunch),category,freeDelivery);
				l.add(m);
			}
			//System.out.println(l);
			String t = "select sum(m.price) from menu_item as m " + 
					"JOIN cart as c " + 
					"on m.id = c.menuItemId " + 
					"where c.userId = ?;";
			PreparedStatement p2 = con.prepareStatement(t);
			p2.setInt(1,(int)userId);
			ResultSet rs = p2.executeQuery();
			rs.next();
			float totalPrice = rs.getFloat(1);
			c.setMenuItemList(l);
			c.setTotal((double)totalPrice);
			
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
	public void removeCartItem(long userId, long menuItemId) {
		try {
			Connection con = ConnectionHandler.getConnection();
			//String s = "delete from cart where userId=? and menuItemId=?;";
			String s = "delete from cart where menuItemId=?;";
			PreparedStatement p = con.prepareStatement(s);
			//p.setInt(1,(int)userId);
			p.setInt(1,(int)menuItemId);
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
