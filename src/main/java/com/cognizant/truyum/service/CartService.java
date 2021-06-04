package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	
	@Autowired
	CartDaoSqlImpl ob;
	
	public void addToCart(int id) {
		ob.addCartItem(1, id);
	}

	public List<MenuItem> getAllCartItem(int userId) throws CartEmptyException {
			List<MenuItem> allCartItems = ob.getAllCartItems(userId);
		return allCartItems;
	}
	
	public void removeItem(int id) {
		ob.removeCartItem(1, id);
	}
	
}
