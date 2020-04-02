package com.wellsfargo.run;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subcategory")
public class SubcategoryDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subcategoryid")
	private Long subcategoryid;
	
	@Column(name = "subcategoryName")
	private String subcategoryName;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="categories_subcategories", joinColumns=@JoinColumn(name="subcategoryid"), inverseJoinColumns=@JoinColumn(name="categoryid"))
	private List<CategoryDTO> category=new ArrayList<>();

	@OneToMany(mappedBy="subcategoryProduct")
	private List<ProductDTO> products = new ArrayList<>();

	
	public SubcategoryDTO() {
		super();
	}

	public SubcategoryDTO(Long subcategoryid, String subcategoryName, List<CategoryDTO> category) {
		super();
		this.subcategoryid = subcategoryid;
		this.subcategoryName = subcategoryName;
		this.category = category;
	}

	public Long getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(Long subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	/*public List<CategoryDTO> getCategory() {
		return category;
	}
*/
	public void setCategory(List<CategoryDTO> category) {
		this.category = category;
	}

	/*@Override
	public String toString() {
		return "SubcategoryDTO [subcategoryid=" + subcategoryid + ", subcategoryName=" + subcategoryName + ", category="
				+ category + "]";
	}*/
	
		
}
