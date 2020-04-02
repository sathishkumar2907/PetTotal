package com.wellsfargo.run;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Long>{

	//List<ProductDTO> findByActiveOrCategotyProduct(String a,String b);
}
