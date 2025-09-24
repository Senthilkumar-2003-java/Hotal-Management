package com.green.GreenHotal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.green.GreenHotal.exception.OurException;
import com.green.GreenHotal.repo.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(username).orElseThrow(()-> new OurException("Username/Email not Found"));
	}

}
