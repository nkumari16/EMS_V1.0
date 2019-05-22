/**
 * 
 */
package com.globant.EMS.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.EMS.dao.UserRepository;
import com.globant.EMS.model.Role;
import com.globant.EMS.model.User;

/**
 * @author mayuri.shinde
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {
	@Autowired
	UserRepository userRepository;

	@SuppressWarnings("unchecked")
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		System.out.println("user............." + principal.getName());
		User authenticatedUser = userRepository.findByUsername(principal.getName());
		if (authenticatedUser == null) {
			OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
			Authentication authentication = oAuth2Authentication.getUserAuthentication();
			Map<String, String> details = new LinkedHashMap<>();
			details = (Map<String, String>) authentication.getDetails();
			Map<String, String> map = new LinkedHashMap<>();
			map.put("email", details.get("email"));

			User user = new User();
			user.setUsername(details.get("name"));
			user.setEmail(details.get("email"));

			Role role = new Role();
			role.setRoleId(1);
			role.setRoleName("Admin");

			user.setRole(role);
			userRepository.save(user);
		}
		
		return principal;
	}
	@RequestMapping("/roles")
	public List<Role> roles() {
		System.out.println("roles.............");
		List<Role> roles=new ArrayList<Role>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		String auth =  (String) authentication.getPrincipal();
		System.out.println("currentPrincipalName---" + currentPrincipalName + "auth--------" + auth);
		roles=userRepository.getUserRoles(currentPrincipalName);
		System.out.println("roles---" + roles);
		return roles;
	}
	
	@RequestMapping("/login")
	public void login() {
		System.out.println("login.............");
	}
}
