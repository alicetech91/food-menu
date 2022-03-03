package com.justeat.menusync.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu")
public class MenuDTO {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private int id;
	@Column(name = "menu_id")
    private int menuId;
    @Column(name = "category") 
    private String category;
    @Column(name = "product_id") 
    private String productId;
    @Column(name = "product_name") 
    private String productName;
    @Column(name = "product_desc") 
    private String productDesc;
    @Column(name = "size") 
    private String size;
    @Column(name = "uom") 
    private String uom;
    @Column(name = "unit_price") 
	private BigDecimal unitPrice;
    @Column(name = "qty_in_stock") 
	private Integer qtyInStock;
    @Column(name = "is_available") 
	private String isAvailable;
	public MenuDTO orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
