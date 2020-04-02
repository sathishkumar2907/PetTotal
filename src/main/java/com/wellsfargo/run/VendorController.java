package com.wellsfargo.run;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@GetMapping(value = "/vendorpage", produces = "application/json")
	public String vendorPage() {
		return "vendor";
	}

	@PostMapping(value = "/save", produces = "application/json")
	@ResponseBody
	public Map<String, Object> saveMentor(@RequestBody VendorDTO vendorDTO) {
		Map<String, Object> responseMap = new HashMap<>();

		VendorDTO vendoObj = vendorService.saveVendor(vendorDTO);
		responseMap.put("Message", "Vendor is added successfully");
		responseMap.put("data", vendoObj);

		return responseMap;
	}

	@GetMapping(value = "/", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getAllMentor() {
		Map<String, Object> responseMap = new HashMap<>();
		List<VendorDTO> getallvendors;
		getallvendors = vendorService.getAllvendors();
		responseMap.put("data", getallvendors);
		return responseMap;

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getvendorById(@PathVariable("id") Long vendorId) {
		Map<String, Object> responseMap = new HashMap<>();
		VendorDTO getvendorById;
		getvendorById = vendorService.getvendorById(vendorId);
		responseMap.put("data", getvendorById);

		return responseMap;
	}

	@PutMapping(value = "/update", produces = "application/json")
	@ResponseBody
	public Map<String, Object> updateVendor(@RequestBody VendorDTO vendorDTO) {
		VendorDTO vendorDTOObj = null;
		Map<String, Object> responseMap = new HashMap<>();

		vendorDTOObj = vendorService.updateVendor(vendorDTO);
		responseMap.put("Message", "Vendor is updated successfully");
		responseMap.put("data", vendorDTOObj);
		return responseMap;

	}

	@PutMapping(value = "/update/{id}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> update(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
		VendorDTO vendorDTOObj = null;
		Map<String, Object> responseMap = new HashMap<>();

		vendorDTOObj = vendorService.updateMentor(vendorDTO, id);
		responseMap.put("Message", "Vendor is updated successfully");
		responseMap.put("data", vendorDTOObj);
		return responseMap;

	}

}
