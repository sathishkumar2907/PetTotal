package com.wellsfargo.run;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CategoryDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)// Next change the value
	@Column(name = "categoryid")
	private Long categoryid;
	
	@Column(name = "categoryName")
	private String categoryName;
	
	@ManyToMany(mappedBy="category")
	private List<SubcategoryDTO> subcategories = new ArrayList<>();
	
	@OneToMany(mappedBy="categoryProduct")
	private List<ProductDTO> products = new ArrayList<>();

    
	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Long categoryid, String categoryName) {
		super();
		this.categoryid = categoryid;
		this.categoryName = categoryName;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<SubcategoryDTO> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<SubcategoryDTO> subcategories) {
		this.subcategories = subcategories;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryid=" + categoryid + ", categoryName=" + categoryName + ", subcategories="
				+ subcategories + "]";
	}
	
	
}
