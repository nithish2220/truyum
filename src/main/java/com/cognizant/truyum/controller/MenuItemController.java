package com.cognizant.truyum.controller;



import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	
	@GetMapping(value ="/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model){
		LOGGER.info("Start");
		List<MenuItem> menuItemListAdmin = menuItemService.getMenuItemListAdmin();
		model.put("menuItemListAdmin", menuItemListAdmin);
		return "menu-item-list-admin";
	}

	@GetMapping(value="/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) {
		LOGGER.info("Start");
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		model.put("menuItemListCustomer", menuItemListCustomer);
		return "menu-item-list-customer";
	}
	
	@GetMapping(value="/show-edit-menu-item")
	public String showEditMenuItem(@RequestParam int id,ModelMap model) {
		MenuItem menuItem = menuItemService.getMenuItem(id);
		model.put("menuItem", menuItem);
		return "edit-menu-item";
	}
	
	@PostMapping(value="/edit-menu-item")
	public String editMenuItem(@Valid MenuItem menuItem, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "edit-menu-item";
		}
		menuItemService.modifyMenuItem(menuItem);
		return "edit-menu-item-status";
	}
}
