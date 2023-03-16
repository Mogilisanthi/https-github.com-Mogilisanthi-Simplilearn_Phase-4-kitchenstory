package com.simplilearn.kitchenstory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminDao {
	@Autowired
	AdminRepo ad_repo;
	
	public Admin insert(Admin a) {
		return ad_repo.save(a);
	}
		

}
