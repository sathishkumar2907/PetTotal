package com.wellsfargo.run;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactusRespository extends JpaRepository<ContactusDTO, Long>{

	List<ContactusDTO> findByNameOrContactNumberOrContactEmail(String name, String contactnumber,String contactemail);
}
