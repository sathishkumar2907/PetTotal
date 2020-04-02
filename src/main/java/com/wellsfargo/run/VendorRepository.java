package com.wellsfargo.run;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<VendorDTO, Long>{

	VendorDTO findById(long id);
	
}
