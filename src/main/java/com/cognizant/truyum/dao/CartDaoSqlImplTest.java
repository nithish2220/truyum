/*package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	
	public static void main(String args[]) {
		//CartDaoSqlImplTest.testAddCartItem();
		CartDaoSqlImplTest.testGetAllCartItems();
		CartDaoSqlImplTest.testRemoveCartItem();
		CartDaoSqlImplTest.testGetAllCartItems();
	}

	static void testAddCartItem() {
		System.out.println("Adding to cart.");
		CartDaoSqlImpl c = new CartDaoSqlImpl();
		c.addCartItem(1,5);
		c.addCartItem(1,1);
	}

	static void testGetAllCartItems() {
		System.out.println("All Cart Items of Customer.");
		CartDaoSqlImpl c = new CartDaoSqlImpl();
		try {
			List<MenuItem> l = c.getAllCartItems(1);
			for(int i=0;i<l.size();i++) System.out.println(l.get(i));
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void testRemoveCartItem() {
		System.out.println("Removing from cart");
		CartDaoSqlImpl c = new CartDaoSqlImpl();
		c.removeCartItem(1,5);
	}
}
*/