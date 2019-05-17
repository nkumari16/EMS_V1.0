/**
 * 
 */
package com.globant.EMS.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mayuri.shinde
 *
 */
@RestController
public class UserRestController {
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		System.out.println("user.............") ;
		return principal;
	}
	@RequestMapping("/login")
	public String login( ) {
		System.out.println("login.............") ;
		return "login";
	}
	@RequestMapping("/logout")
	public String logoutPage () {
		System.out.println("logout.............");
	   
	    return "tets";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
