package com.funddoauthorization.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.funddoauthorization.model.AuthUserDetail;
import com.funddoauthorization.model.User;
import com.funddoauthorization.repository.UserDetailRepository;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	UserDetailRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Optional<User> optionalUser = repository.findByUsername(username);
        
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password is incorrect"));
        
        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        
        new AccountStatusUserDetailsChecker().check(userDetails);
        
        return userDetails;
	}

	

}
