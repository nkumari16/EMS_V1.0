/**
 * 
 */
package com.globant.EMS.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.EMS.model.Role;

/**
 * @author mayuri.shinde
 *
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@RequestMapping("/admin")
	public Role admin(HttpServletRequest request) {
//		request.isUserInRole("someAuthority");
		hasRole("Admin");
		System.out.println("admin............."+hasRole("Admin")+ " "+request.isUserInRole("Admin"));
		Role r=new Role();
		r.setRoleId(55);
		return r;
	}
	
	private boolean hasRole(String role) {
		  Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
		  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		  boolean hasRole = false;
		  for (GrantedAuthority authority : authorities) {
			 System.out.println("authority----"+authority.getAuthority());
		     hasRole = authority.getAuthority().equals(role);
		     if (hasRole) {
			  break;
		     }
		  }
		  return hasRole;
		} 
}
