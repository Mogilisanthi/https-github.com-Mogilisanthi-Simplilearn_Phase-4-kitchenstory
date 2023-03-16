package com.simplilearn.kitchenstory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer>{
	@Query("select user from User user where user.username=?1 and user.password=?2")
	public User findByuserpwd(String username,String password) ;
}
