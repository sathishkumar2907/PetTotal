package com.wellsfargo.run;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactusServiceImpl implements ContactusService{

	@Autowired
	private ContactusRespository contactusRepository;
	
	@Override
	public ContactusDTO saveContactus(ContactusDTO contactusDTO) {
		
		ContactusDTO contactusObj=contactusRepository.save(contactusDTO);
		
		return contactusObj;
		
	}
	
	@Override
	public List<ContactusDTO> getContacuslist() {
		List<ContactusDTO> getcontactuslist=null;
		
        try{
			
        	getcontactuslist=contactusRepository.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return getcontactuslist;
	}
	
	@Override
	public List<ContactusDTO> findByNameOrContactNumberOrContactEmail(String name, String contactnumber, String contactemail) {
	   
		List<ContactusDTO> contactusDTO=null;
		
		contactusDTO = contactusRepository.findByNameOrContactNumberOrContactEmail(name, contactnumber, contactemail);
		
		return contactusDTO;
	}

}
