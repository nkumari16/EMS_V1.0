package com.globant.EMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globant.EMS.model.Role;
import com.globant.EMS.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	 @Query("SELECT u FROM User u WHERE u.username = :username")
	    User findByUsername(@Param("username") String username);
	 
	 @Query("SELECT r FROM User u JOIN Role r ON u.role.roleId = r.roleId WHERE u.username = :username")
	    List<Role> getUserRoles(@Param("username") String username);
}
