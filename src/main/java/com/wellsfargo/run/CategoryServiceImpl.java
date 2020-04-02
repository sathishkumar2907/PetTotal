package com.wellsfargo.run;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
     
		CategoryDTO categoryObj = null;
		try {

			categoryObj = categoryRepository.save(categoryDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryObj;
	}

	@Override
	public List<CategoryDTO> getallCategories() {
		List<CategoryDTO> getallcategories = null;

		try {

			getallcategories = categoryRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return getallcategories;
	}
	
	@Override
	public CategoryDTO findById(long id) {
		CategoryDTO categoryDTO=null;
        try{
			
        	categoryDTO=categoryRepository.findById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoryDTO;
	}

	@Override
	public List<SubcategoryDTO> getSubcategoiesByCategory(Long categoryId) {
      List<SubcategoryDTO> subcategorieslist=null;
		
		try{
			
			subcategorieslist=categoryRepository.getSubcategoiesByCategory(categoryId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return subcategorieslist;
	}
	
	
	

}
