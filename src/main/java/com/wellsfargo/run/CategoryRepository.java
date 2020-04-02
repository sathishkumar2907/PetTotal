package com.wellsfargo.run;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDTO, Long>{

	CategoryDTO findById(long id);
	CategoryDTO findByCategoryName(String categoryname);
	@Query("select category.subcategories from CategoryDTO AS category where category.categoryid=:categoryId")
	List<SubcategoryDTO> getSubcategoiesByCategory(@Param("categoryId") Long categoryId);
	
	/*@Query("select category.subcategories,sub.subcategoryName from CategoryDTO AS category inner join"
			+ " categories_subcategories AS catsub on (category.categoryid=catsub.subcategoryid) inner join SubcategoryDTO AS sub "
			+ " on (catsub.subcategoryid=sub.subcategoryid) where category.categoryid=:categoryId")
	List<SubcategoryDTO> getSubcategoiesByCategory1(@Param("categoryId") Long categoryId);*/
	/*select u.email, r.role_name from user u inner join user_role ur on(u.id=ur.id) 
	inner join role r on(ur.role_id=r.role_id) where u.email=?
*/
}
