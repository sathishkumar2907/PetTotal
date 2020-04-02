package com.wellsfargo.run;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProuctServiceImpl implements ProductService{

	@Autowired
	private ProductRepository prouctRepository;
	
	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		ProductDTO productObj;
		 productObj= prouctRepository.save(productDTO);		
		return productObj;
	}

	@Override
	public List<ProductDTO> getAllProucts() {
		List<ProductDTO> getallproducts;
		getallproducts = prouctRepository.findAll();
		return getallproducts;
	}

}
