package com.wellsfargo.run;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private Long productid;

	@Column(name = "productName")
	private String productName;

	@Column(name = "productDescription")
	private String productDescription;

	@Column(name = "productPrice")
	private int productPrice;

	@Column(name = "productQuantity")
	private int productQuantity;

	@Column(name = "productAvailability")
	private int productAvailability;

	@Column(name = "active")
	private int active;

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private VendorDTO vendorProduct;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryDTO categoryProduct;

	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	private SubcategoryDTO subcategoryProduct;

	public ProductDTO() {
		super();
	}

	public ProductDTO(Long productid, String productName, String productDescription, int productPrice,
			int productQuantity, int productAvailability, int active, VendorDTO vendorId, CategoryDTO categoryid,
			SubcategoryDTO subcategoryid) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productAvailability = productAvailability;
		this.active = active;
		this.vendorProduct = vendorId;
		this.categoryProduct = categoryid;
		this.subcategoryProduct = subcategoryid;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(int productAvailability) {
		this.productAvailability = productAvailability;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}


	public VendorDTO getVendorProduct() {
		return vendorProduct;
	}

	public void setVendorProduct(VendorDTO vendorProduct) {
		this.vendorProduct = vendorProduct;
	}

	public CategoryDTO getCategoryProduct() {
		return categoryProduct;
	}

	public void setCategoryProduct(CategoryDTO categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	public SubcategoryDTO getSubcategoryProduct() {
		return subcategoryProduct;
	}

	public void setSubcategoryProduct(SubcategoryDTO subcategoryProduct) {
		this.subcategoryProduct = subcategoryProduct;
	}

	@Override
	public String toString() {
		return "ProductDTO [productid=" + productid + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", productAvailability=" + productAvailability + ", active=" + active + ", vendorId=" + vendorProduct
				+ ", categoryProduct=" + categoryProduct + ", subcategoryProduct=" + subcategoryProduct + "]";
	}

}
