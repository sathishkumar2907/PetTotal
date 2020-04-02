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
@RequestMapping("/contactus")
public class ContactusController {
	
	@Autowired
	private ContactusService contactusService;
	
	@GetMapping(value="/contactuspage",produces="application/json")
	public String mentorPage(){
		return "contactus";
	}
	
	@PostMapping(value="/save",produces="application/json")
	@ResponseBody
    public Map<String,Object> save(@RequestBody ContactusDTO contactusDTO){
		Map<String,Object> response=new HashMap<>();
		
		if(contactusDTO.getContactEmail().equals(null) || contactusDTO.getContactEmail().equals("")){
			response.put("message", "Please provide email");
			response.put("data", null);
			
			
		}else{
		
		
		ContactusDTO contactusObj=contactusService.saveContactus(contactusDTO);
		response.put("message", "Successfully saved the record");
		response.put("data", contactusObj);
		}
		return response;
	}
	
	@GetMapping(value="/", produces="application/json")
	@ResponseBody
	public Map<String, Object> getContactsuslist(){
		Map<String, Object> responseMap=new HashMap<>();
         List<ContactusDTO> getcontactuslist;
         getcontactuslist=contactusService.getContacuslist();
         responseMap.put("data", getcontactuslist);
         return responseMap;
         
	}
	
	@GetMapping(value="/search/{searchdata}", produces="application/json")
	@ResponseBody
	public Map<String,Object> findByNameOrContactNumber(@PathVariable(value="searchdata") String searchdata){
		Map<String,Object> responseMap=new HashMap<String, Object>();
		
		List<ContactusDTO> getsearchdata;
		
		getsearchdata = contactusService.findByNameOrContactNumberOrContactEmail(searchdata, searchdata, searchdata);
		responseMap.put("data", getsearchdata);
		
		return responseMap;
	}
	
}
