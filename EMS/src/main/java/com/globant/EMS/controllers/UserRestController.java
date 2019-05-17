/**
 * 
 */
package com.globant.EMS.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		return principal;
	}
//	@RequestMapping("/goToClient")
//	public String login( ) {
//		System.out.println("goToClient.............") ;
//		return "redirect:http://localhost:4200/";
//	}
	@RequestMapping(value = "/goToClient", method = RequestMethod.GET)
	public String method() {
		System.out.println("goToClient.............") ;
	    return "forward:/index.html";
	}
	@RequestMapping("/logout")
	public String logoutPage () {
		System.out.println("logout.............");
	   
	    return "tets";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
