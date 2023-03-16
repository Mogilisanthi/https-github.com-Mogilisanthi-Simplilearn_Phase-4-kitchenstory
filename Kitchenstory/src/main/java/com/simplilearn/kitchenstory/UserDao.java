package com.simplilearn.kitchenstory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserDao {
	@Autowired
	UserRepo u_repo;
	
	public User insert(User u) {
		return u_repo.save(u);
	}

}
