package com.wellsfargo.run;

import java.util.List;

public interface VendorService {

	VendorDTO saveVendor(VendorDTO vendorDTO);
	List<VendorDTO> getAllvendors();
	VendorDTO findById(long id);
	VendorDTO updateMentor(VendorDTO vendorDTO, long id);
	VendorDTO getvendorById(Long vendorId);
	VendorDTO updateVendor(VendorDTO vendorDTO);

	
}
