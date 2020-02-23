package com.javacodegeeks.user.service;

import com.javacodegeeks.user.domain.User;

/**
 * Default implementation of {@link UserService}
 * @author Meraj
 *
 */
public class DefaultUserService implements UserService {

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserDetails(User newUserDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getUserCount() {
		throw new UnsupportedOperationException("Not implemented");
	}

}
