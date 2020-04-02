package com.wellsfargo.run;


import java.util.List;


public interface UserService {
 
	void saveUser(UserDTO userDTO);
	UserDTO findUserByEmail(String email);
	List<RoleDTO> getRoles();
}