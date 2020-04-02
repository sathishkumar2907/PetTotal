package com.wellsfargo.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

	@Autowired
	private SubcategoryRepository subcategoryrepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryDTO findById(long id) {
		CategoryDTO categoryDTO = null;
		
		try {

			categoryDTO = categoryRepository.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryDTO;
	}

	@Override
	public SubcategoryDTO savesubcategory(SubcategoryDTO subcategoryDTO, Long id) {

		CategoryDTO categoryDTO = null;
		SubcategoryDTO subcategoryObj = null;

		try {

			categoryDTO = categoryRepository.findByCategoryName("Clothes");
			categoryDTO = findById(id);
			subcategoryDTO.setCategory(new ArrayList<CategoryDTO>(Arrays.asList(categoryDTO)));
			subcategoryObj = subcategoryrepository.save(subcategoryDTO);

		} catch (Exception e) {
			e.getStackTrace();
		}
		return subcategoryObj;
	}

	@Override
	public List<SubcategoryDTO> getallsubcategories() {
		List<SubcategoryDTO> getallsubcategories;
		getallsubcategories = subcategoryrepository.findAll();
		
		return getallsubcategories;
	}

}
