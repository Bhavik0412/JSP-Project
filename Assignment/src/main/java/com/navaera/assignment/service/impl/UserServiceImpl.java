package com.navaera.assignment.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.navaera.assignment.entity.Role;
import com.navaera.assignment.entity.User;
import com.navaera.assignment.repository.RoleRepository;
import com.navaera.assignment.repository.UserRepository;
import com.navaera.assignment.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;

	@Override
	public String saveUser(User user) {
		Optional<Role> findById = roleRepo.findById(1L);
		if (findById.isPresent()) {
			Role role = findById.get();
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRoles(roles);
		}
		User save = userRepo.save(user);
		return save.getUsername();
	}

}
