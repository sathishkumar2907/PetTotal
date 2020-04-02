package com.wellsfargo.run;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/addcategorypage", produces = "application/json")
	public String vendorPage() {
		return "category";
	}

	@PostMapping(value = "/save", produces = "application/json")
	@ResponseBody
	public Map<String, Object> saveCategory(@RequestBody CategoryDTO categoryDTO) {
		Map<String, Object> responseMap = new HashMap<>();

		CategoryDTO categoryobj = categoryService.saveCategory(categoryDTO);
		responseMap.put("Message", "Vendor is added successfully");
		responseMap.put("success", "true");
		responseMap.put("data", categoryobj);

		return responseMap;
	}

	@GetMapping(value = "/", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllCategory() {
		Map<String, Object> responseMap = new HashMap<>();
		List<CategoryDTO> getallcategory;
		getallcategory = categoryService.getallCategories();
		responseMap.put("data", getallcategory);
		return responseMap;

	}
	
	//*** This method is used to get the subcategories based on the category id
	@GetMapping(value="/{categoryId}/subcategorylist", produces="application/json")
	@ResponseBody
	public Map<String, Object> getMenteesByMentor(@PathVariable("categoryId") Long categoryId){
		Map<String, Object> responseMap=new HashMap<>();
         List<SubcategoryDTO> getSubcategoiesByCategory;
         getSubcategoiesByCategory=categoryService.getSubcategoiesByCategory(categoryId);
         responseMap.put("data", getSubcategoiesByCategory);
         return responseMap;
         
	}

}
