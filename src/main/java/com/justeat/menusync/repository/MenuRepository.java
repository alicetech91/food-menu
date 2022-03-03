package com.justeat.menusync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.justeat.menusync.model.MenuDTO;


public interface MenuRepository extends JpaRepository<MenuDTO, Integer>{
	
	MenuDTO findByProductId(String productId);
	List<MenuDTO> findByMenuId(int menuId);
	MenuDTO findByMenuIdAndProductId(int menuId, String productId);
	@Transactional
	@Modifying
	@Query(value ="UPDATE MENU set CATEGORY =:#{#menuDTO.category},PRODUCT_NAME =:#{#menuDTO.productName},"
			+ "PRODUCT_DESC =:#{#menuDTO.productDesc},SIZE =:#{#menuDTO.size},UOM =:#{#menuDTO.uom},"
			+ "UNIT_PRICE =:#{#menuDTO.unitPrice},QTY_IN_STOCK =:#{#menuDTO.qtyInStock},IS_AVAILABLE =:#{#menuDTO.isAvailable}"
			+ "  WHERE MENU_ID = :#{#menuDTO.menuId} AND PRODUCT_ID=:#{#menuDTO.productId}", nativeQuery=true)
	int updateMenu(@Param("menuDTO") MenuDTO menuDTO);
	
	
}
