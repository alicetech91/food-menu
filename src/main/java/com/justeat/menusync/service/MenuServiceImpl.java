package com.justeat.menusync.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justeat.menusync.exception.MenuNotFoundException;
import com.justeat.menusync.model.MenuDTO;
import com.justeat.menusync.repository.MenuRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
    MenuRepository menuRepository;
	

	/**
	 * To find by menu id form Menu table
	 * 
	 * @param id
	 * @return
	 */
	public List<MenuDTO> getMenu(int id) {
		List<MenuDTO> menuDTOs= menuRepository.findByMenuId(id);
		if(menuDTOs !=null)
			return menuDTOs;
		else {
			log.error("Service has not found anything matching the Request :");
			throw new MenuNotFoundException();
		}
	}
	
	 /**
     * To find all object from Menu table
     * 
     * @return
     */
    public List<MenuDTO> getMenus() throws Exception {
    	List<MenuDTO> menuDTOs= new ArrayList<MenuDTO>();
    	try {
    		menuDTOs= menuRepository.findAll();
    	}catch (Exception ex) {
    		log.error("Exception occurred while fetching All menu details:"+ex.getMessage());
			throw new Exception(ex.getMessage());
		}
    	return menuDTOs;
    }

    /**
     * To save MenuDTO object in Menu table
     * 
     * @param menuDTO
     */
	public MenuDTO menuSync(MenuDTO menuDTO) throws Exception {

		try {
			MenuDTO menuToUpdate = menuRepository.findByMenuIdAndProductId(menuDTO.getMenuId(), menuDTO.getProductId());
			log.info("Inside menuSync service:" + menuToUpdate);

			if (menuToUpdate != null) {
				log.debug("MenuSync UPDATE Path");
				menuToUpdate.setMenuId(menuDTO.getMenuId());
				menuToUpdate.setCategory(menuDTO.getCategory());
				menuToUpdate.setProductId(menuDTO.getProductId());
				menuToUpdate.setProductName(menuDTO.getProductName());
				menuToUpdate.setProductDesc(menuDTO.getProductDesc());
				menuToUpdate.setSize(menuDTO.getSize());
				menuToUpdate.setUom(menuDTO.getUom());
				menuToUpdate.setUnitPrice(menuDTO.getUnitPrice());
				menuToUpdate.setQtyInStock(menuDTO.getQtyInStock());
				menuToUpdate.setIsAvailable(menuDTO.getIsAvailable());
				int result = menuRepository.updateMenu(menuToUpdate);
				log.debug("Result of Updae :" + result);
				return menuToUpdate;
			} else {
				log.debug("MenuSync CREATE Path");
				return menuRepository.save(menuDTO);
			}
		} catch (Exception ex) {
			log.error("Exception occurred while doing MenuSync operation:"+ex.getMessage());
			throw new Exception(ex.getMessage());
		}

	}
	
	
}
