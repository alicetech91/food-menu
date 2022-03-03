package com.justeat.menusync.service;

import java.util.List;

import com.justeat.menusync.model.MenuDTO;

public interface MenuService {

	public List<MenuDTO> getMenu(int id);

	public List<MenuDTO> getMenus() throws Exception;

	public MenuDTO menuSync(MenuDTO menuDTO) throws Exception;

}
