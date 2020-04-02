package com.wellsfargo.run;

import java.util.List;

public interface ProductService {

	ProductDTO saveProduct(ProductDTO productDTO);
	List<ProductDTO> getAllProucts();
}
