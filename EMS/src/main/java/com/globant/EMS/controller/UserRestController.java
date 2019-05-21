/**
 * 
 */
package com.globant.EMS.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.EMS.model.User;

/**
 * @author mayuri.shinde
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		System.out.println("user.............") ;
		User user = new User();
		user.setUsername(principal.getName());
		return principal;
	}
	@RequestMapping("/login")
	public void login() {
		System.out.println("login.............") ;
	}
}
