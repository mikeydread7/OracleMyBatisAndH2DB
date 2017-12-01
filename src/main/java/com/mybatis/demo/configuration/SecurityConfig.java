/**
 * 
 */
package com.mybatis.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * 
 * credits code written at
 * https://stackoverflow.com/questions/37285016/what-is-username-and-password-when-starting-spring-boot-with-tomcat
 * 
 * @see <a href=
 *      "https://stackoverflow.com/questions/37285016/what-is-username-and-password-when-starting-spring-boot-with-tomcat">Dynamic
 *      way of creating credential for testing</a>
 */

@Configuration("securityConfig")
// @EnableWebSecurity
public class SecurityConfig {

	// *************************************************************************************************
	// Constants
	private final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

	// fix testing credentials
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		LOG.info("Setting in-memory security using the user input...");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
	// for a dynamic way of creating testing credentials
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * LOG.info("Setting in-memory security using the user input...");
	 * 
	 * Scanner scanner = new Scanner(System.in); String inputUser = null; String
	 * inputPassword = null; System.out.
	 * println("\nPlease set the admin credentials for this web application");
	 * while (true) { System.out.print("user: "); inputUser =
	 * scanner.nextLine(); System.out.print("password: "); inputPassword =
	 * scanner.nextLine(); System.out.print("confirm password: "); String
	 * inputPasswordConfirm = scanner.nextLine();
	 * 
	 * if (inputUser.isEmpty()) {
	 * System.out.println("Error: user must be set - please try again"); } else
	 * if (inputPassword.isEmpty()) {
	 * System.out.println("Error: password must be set - please try again"); }
	 * else if (!inputPassword.equals(inputPasswordConfirm)) { System.out.
	 * println("Error: password and password confirm do not match - please try again"
	 * ); } else { LOG.
	 * info("Setting the in-memory security using the provided credentials...");
	 * break; } System.out.println(""); } scanner.close();
	 * 
	 * if (inputUser != null && inputPassword != null) {
	 * auth.inMemoryAuthentication() .withUser(inputUser)
	 * .password(inputPassword) .roles("USER"); } }
	 */
}