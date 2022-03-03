package com.justeat.menusync.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justeat.menusync.model.MenuDTO;
import com.justeat.menusync.service.MenuService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/menu")
@Tag(name = "MenuController", description = "REST API related to Menu Service!!!!!!!")
public class MenuController {
	
	@Autowired
	MenuService menuService;
		 	
	@GetMapping("/getMenu/{id}")
	public List<MenuDTO> getMenu(@PathVariable int id) throws Exception {	
		return  menuService.getMenu(id);
	}
	@GetMapping("/getMenus")
	public List<MenuDTO> getMenus() throws Exception {	
		return  menuService.getMenus();
	}
	
	@PostMapping("/menuSync")
	public MenuDTO menuSync(@RequestBody MenuDTO menuDTO) {
		MenuDTO menuToSync = new MenuDTO();
	     try {
	    	 menuToSync= menuService.menuSync(menuDTO);
		} catch (Exception e) {
			log.error("Exception occurred during MenuSync:"+e.getMessage());
			e.printStackTrace();
		}
		return menuToSync;
	       
	}
	

}
