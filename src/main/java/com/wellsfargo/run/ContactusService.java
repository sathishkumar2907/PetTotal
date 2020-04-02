package com.wellsfargo.run;

import java.util.List;

public interface ContactusService {

	ContactusDTO saveContactus(ContactusDTO contactusDTO);
    List<ContactusDTO> getContacuslist();
	List<ContactusDTO> findByNameOrContactNumberOrContactEmail(String name, String contactnumber, String contactemail);
}
