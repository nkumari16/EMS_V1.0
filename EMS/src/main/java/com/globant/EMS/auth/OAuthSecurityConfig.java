/**
 * 
 */
package com.globant.EMS.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Modifying or overriding the default spring boot security.
 * 
 * @author mayuri.shinde
 *
 */
@Configurable
//@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
@Order
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	OAuth2ClientContext oauth2ClientContext;
	@Autowired
	AuthorizationCodeResourceDetails authorizationCodeResourceDetails;
	@Autowired
	ResourceServerProperties resourceServerProperties;

	// This method is for overriding the default AuthenticationManagerBuilder.
	// We can specify how the user details are kept in the application. It may
	// be in a database, LDAP or in memory.
	@Override
	//@Order(Ordered.HIGHEST_PRECEDENCE)
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		/*
		 * auth .inMemoryAuthentication()
		 * .withUser("user").password("user").roles("USER").and()
		 * .withUser("admin").password("admin").roles("ADMIN","REPORT");
		 */}

	// This method is for overriding some configuration of the WebSecurity
	// If you want to ignore some request or request patterns then you can
	// specify that inside this method
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	/**
	 * Method for creating filter for OAuth authentication
	 * 
	 * @return OAuth2ClientAuthenticationProcessingFilter
	 */
	private OAuth2ClientAuthenticationProcessingFilter filter() {
		System.out.println("In filter ");
		// Creating the filter for "/google/login" url
		OAuth2ClientAuthenticationProcessingFilter oAuth2Filter = new OAuth2ClientAuthenticationProcessingFilter(
				"/login");

		// Creating the rest template for getting connected with OAuth service.
		// The configuration parameters will inject while creating the bean.
		OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(authorizationCodeResourceDetails,
				oauth2ClientContext);
		oAuth2Filter.setRestTemplate(oAuth2RestTemplate);

		// setting the token service. It will help for getting the token and
		// user details from the OAuth Service
		oAuth2Filter.setTokenServices(new UserInfoTokenServices(resourceServerProperties.getUserInfoUri(),
				resourceServerProperties.getClientId()));

		return oAuth2Filter;
	}
	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
        	   .authorizeRequests()
	           .antMatchers("/static","/register").permitAll()
	           //.antMatchers("/admin/**").hasRole("mayuri")
	           .antMatchers("/admin/**").access("hasRole('mayuri')")
	            
	//           .antMatchers("/admin/**").access("hasRole('ADMIN') and hasIpAddress('123.123.123.123')") // pass SPEL using access method
	           .anyRequest().authenticated()
	       .and()
	       		.exceptionHandling().accessDeniedPage("/error/403")
           .and()
		       .formLogin()
		       .loginPage("/login")
		       .permitAll()
			.and()
		        .logout()
		        .permitAll();
		
		

//		http.httpBasic().and()
		//.cors().and()
				// starts authorizing configurations
//				.authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/admin").hasRole("Admin") 
				// ignore the "/" and "/index.html"
//				.antMatchers("/", "/**.html", "/**.js").permitAll()
				// authenticate all remaining URLS
//				.anyRequest().fullyAuthenticated()//
//				.and()//
				// setting the logout URL "/logout" - default logout URL
//				.logout()//
				// after successful logout the application will redirect to "/"
				// path
//				.logoutSuccessUrl("/")//
//				.permitAll()//
//				.and()//
				// Setting the filter for the URL "/google/login"
//				.addFilterAt(filter(), BasicAuthenticationFilter.class)//
//				.and()
//				.csrf()//
//				.disable();
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

	@Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
//	protected void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		System.out.println("in client config");
//        clients
//            .inMemory()
//                .withClient("first-client")
//                .secret(passwordEncoder().encode("noonewilleverguess"))
//                .scopes("resource:read")
//                .authorizedGrantTypes("authorization_code")
//                .redirectUris("http://localhost:4200/");
//    }
	@Bean
    public PrincipalExtractor githubPrincipalExtractor() {
        return new GooglePrincipalExtractor();
    }
	@Bean
    public AuthoritiesExtractor googleAuthoritiesExtractor() {
        return new GoogleAuthoritiesExtractor();
    }
}
