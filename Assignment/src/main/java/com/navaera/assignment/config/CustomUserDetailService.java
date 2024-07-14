package com.navaera.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.navaera.assignment.entity.User;
import com.navaera.assignment.repository.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user1 = userRepo.findByUsername(username);
		if (user1.isPresent()) {
			User user = user1.get();
			return new CustomUserDetail(user);
		} else {
			throw new UsernameNotFoundException("user is not found with username/email/number");
		}
	}
}