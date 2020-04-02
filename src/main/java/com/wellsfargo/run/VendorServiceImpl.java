package com.wellsfargo.run;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public VendorDTO saveVendor(VendorDTO vendorDTO) {

		VendorDTO vendorObj = null;
		try {

			vendorObj = vendorRepository.save(vendorDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendorObj;
	}

	@Override
	public List<VendorDTO> getAllvendors() {
		List<VendorDTO> getallvendor = null;

		try {

			getallvendor = vendorRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return getallvendor;
	}

	@Override
	public VendorDTO findById(long id) {
		VendorDTO vendorDTO=null;
        try{
			
        	vendorDTO=vendorRepository.findById(id);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return vendorDTO;
	}
	
	@SuppressWarnings("null")
	@Override
	public VendorDTO updateVendor(VendorDTO vendorDTO) {
		VendorDTO existingVendor=null;
		
		 try{
			
		  /* existingVendor.setOwnerName(vendorDTO.getOwnerName());
			 existingVendor.setOwnerContact(vendorDTO.getOwnerContact());
			 existingVendor.setStoreName(vendorDTO.getStoreName());
			 existingVendor.setStoreContact(vendorDTO.getStoreContact());
			 existingVendor.setLocation(vendorDTO.getLocation()); */ 
			 existingVendor = vendorRepository.save(vendorDTO);
			 
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return existingVendor;
	}

	@Override
	public VendorDTO updateMentor(VendorDTO vendorDTO, long id) {
		VendorDTO existingVendor=null;
		
		 try{
				
			 existingVendor=findById(id);
			 existingVendor.setStoreName(vendorDTO.getStoreName());
			 existingVendor.setStoreContact(vendorDTO.getStoreContact());
			 existingVendor.setOwnerName(vendorDTO.getOwnerName());
			 existingVendor.setOwnerContact(vendorDTO.getOwnerContact());
			 existingVendor.setLocation(vendorDTO.getLocation());
			 
			 vendorRepository.save(existingVendor);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return existingVendor;
	}
	
	@Override
	public VendorDTO getvendorById(Long vendorId) {
		
		VendorDTO vendorById=null;
		
		try{
			
			vendorById=vendorRepository.getOne(vendorId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return vendorById;
	}

}
