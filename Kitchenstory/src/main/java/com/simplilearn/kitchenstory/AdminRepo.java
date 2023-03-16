package com.simplilearn.kitchenstory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	@Query("select admin from Admin admin where admin.ad_email=?1 and admin.ad_password=?2")
	public Admin findByadminpwd(String ad_email,String ad_password) ;

}
