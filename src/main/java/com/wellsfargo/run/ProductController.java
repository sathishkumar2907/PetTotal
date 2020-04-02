package com.wellsfargo.run;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository prouctrepo;

	
	@GetMapping(value = "/productlist", produces = "application/json")
	public String vendorPage() {
		return "products";
	}
	
	@PostMapping(value = "/save", produces = "application/json")
	@ResponseBody
	public Map<String, Object> saveMentor(@RequestBody ProductDTO productDTO) {
		Map<String, Object> responseMap = new HashMap<>();
        ProductDTO productObj;
        productObj = productService.saveProduct(productDTO);
		responseMap.put("Message", "Product is added successfully");
		responseMap.put("data", productObj);
		responseMap.put("success", "true");

		return responseMap;
	}
	
	@GetMapping(value = "/", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllMentor() {
		Map<String, Object> responseMap = new HashMap<>();
		List<ProductDTO> getallproducts;
		
		
		
	    getallproducts = productService.getAllProucts();
		responseMap.put("data", getallproducts);
		return responseMap;

	}

}
