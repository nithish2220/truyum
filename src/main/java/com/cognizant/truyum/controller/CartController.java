package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class CartController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping(value="/add-to-cart")
	public String addToCart(@RequestParam int id, ModelMap model) {
		boolean addCartStatus=true;
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		model.put("menuItemListCustomer", menuItemListCustomer);
		
		cartService.addToCart(id);
		
		model.addAttribute("addCartStatus",addCartStatus);
		
		return "menu-item-list-customer";
	}
	
	@GetMapping(value="/show-cart")
	public String showCart(@RequestParam int userId, ModelMap model) throws CartEmptyException {
		float total = 0.0f;
		
			List<MenuItem> cart = cartService.getAllCartItem(userId);
			if(cart.size()==0)
				return "cart-empty";
			else {
			for(MenuItem item:cart){
				total+=item.getPrice();
			}
			model.addAttribute("cartItems", cart);
			model.addAttribute("total", total);
	
		
			return "cart";
			}
	}
	
	@GetMapping(value="/remove-cart-item")
	public String removeCart(@RequestParam int menuItemId, ModelMap model) throws CartEmptyException {
		List<MenuItem> cart = cartService.getAllCartItem(1);
		if(cart.size()==0)
			return "cart-empty";
		
		boolean removeCartItemStatus = false;
		cartService.removeItem(menuItemId);
		removeCartItemStatus = true;
		model.addAttribute("removeCartItemStatus", removeCartItemStatus);
		cartService.getAllCartItem(1);
		model.addAttribute("cart", cart);
		return "redirect:/show-cart?userId=1";
	}
}
