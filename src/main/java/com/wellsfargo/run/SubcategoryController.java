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
@RequestMapping("/subcategory")
public class SubcategoryController {
	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@GetMapping(value = "/addsubcategorypage", produces = "application/json")
	public String vendorPage() {
		return "subcategory";
	}
	
	@PostMapping(value = "/save/{id}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> saveCategory(@RequestBody SubcategoryDTO subcategoryDTO,@PathVariable("id") Long id) {
		Map<String, Object> responseMap = new HashMap<>();

		SubcategoryDTO subcategoryobj;
		
		subcategoryobj = subcategoryService.savesubcategory(subcategoryDTO,id);
		responseMap.put("Message", "subcategory is added successfully");
		responseMap.put("success", "true");
		responseMap.put("data", subcategoryobj);

		return responseMap;
	}

	@GetMapping(value = "/", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllCategory() {
		Map<String, Object> responseMap = new HashMap<>();
		List<SubcategoryDTO> getallsubcategories;
		getallsubcategories = subcategoryService.getallsubcategories();
		responseMap.put("data", getallsubcategories);
		return responseMap;

	}
}
