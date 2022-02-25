package com.example.websitepractice.services;

import com.example.websitepractice.models.User;
import com.example.websitepractice.models.UserWithRoles;
import com.example.websitepractice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
	private final UserRepository userRepository;

	public UserDetailsLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found for " + username);
		}

		return new UserWithRoles(user);
	}
}
