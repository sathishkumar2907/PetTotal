package com.wellsfargo.run;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void saveUser(UserDTO userDTO) {
		
		RoleDTO roleDTO;
		userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		userDTO.setActive(1);
		roleDTO=roleRepository.findByRoleName("USER");
		System.out.println("roleDTO----> "+roleDTO);
		userDTO.setRoles(new HashSet<RoleDTO>(Arrays.asList(roleDTO)));
		userRepository.save(userDTO); 
	}
	

	@Override
	public UserDTO findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<RoleDTO> getRoles() {
		return roleRepository.findAll();
	}
	
	

}