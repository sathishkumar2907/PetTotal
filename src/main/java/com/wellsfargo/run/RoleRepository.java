package com.wellsfargo.run;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleDTO, Long>{
	RoleDTO findByRoleName(String role);
}
