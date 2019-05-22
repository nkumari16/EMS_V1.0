package com.globant.EMS.auth;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.globant.EMS.dao.UserRepository;
import com.globant.EMS.model.Role;
/**
 * Modifying or overriding the default google oauth  authorities.
 * 
 * @author mayuri.shinde
 *
 */
public class GoogleAuthoritiesExtractor implements AuthoritiesExtractor {
	@Autowired
	UserRepository userRepository;
	
	
//	List<GrantedAuthority> GITHUB_SUBSCRIBED_AUTHORITIES = AuthorityUtils
//			.commaSeparatedStringToAuthorityList("GITHUB_USER,GITHUB_USER_SUBSCRIBED");

	@Override
	public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {

//		if (Objects.nonNull(map.get("plan"))) {
//			if (!((LinkedHashMap) map.get("plan")).get("name").equals("free")) {
//				return GITHUB_SUBSCRIBED_AUTHORITIES;
//			}
//		}
		System.out.println("in extractAuthorities---------------- ");
		List<Role> roles = this.getRoles();
		
		List<GrantedAuthority> AUTHORITIES = AuthorityUtils
				.commaSeparatedStringToAuthorityList(roles.toString());
		return AUTHORITIES;
	}
	
	
	private List<Role> getRoles() {
		List<Role> roles=new ArrayList<Role>();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String currentPrincipalName = authentication.getName();
		System.out.println("currentPrincipalName............." + authentication);

//		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
//		Authentication authentication = oAuth2Authentication.getUserAuthentication();
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println("roles AuthoritiesExtractor............." + ((Principal) principal).getName() +"name-----"+userRepository.getUserRoles(((Principal) principal).getName()));
		return roles;
	}
}