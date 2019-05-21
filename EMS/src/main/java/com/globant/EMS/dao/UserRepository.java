package com.globant.EMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globant.EMS.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
