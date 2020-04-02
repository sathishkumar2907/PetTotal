package com.wellsfargo.run;

import java.util.List;

public interface SubcategoryService {
   
	List<SubcategoryDTO> getallsubcategories();
	SubcategoryDTO savesubcategory(SubcategoryDTO subcategoryDTO, Long id);
	
	
}
