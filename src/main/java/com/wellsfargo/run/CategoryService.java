package com.wellsfargo.run;

import java.util.List;

public interface CategoryService {
 
	CategoryDTO saveCategory(CategoryDTO categoryDTO);
	List<CategoryDTO> getallCategories();
	CategoryDTO findById(long id);
	List<SubcategoryDTO> getSubcategoiesByCategory(Long categoryId);
	
}
