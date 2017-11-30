/**
 * 
 */
package com.mybatis.demo.configuration;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 *  
 * credits code written at  https://stackoverflow.com/questions/37285016/what-is-username-and-password-when-starting-spring-boot-with-tomcat
 *
 */

@Configuration("securityConfig")
//@EnableWebSecurity
public class SecurityConfig {

    
    //*************************************************************************************************
	// Constants
	private final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        LOG.info("Setting in-memory security using the user input...");
        Scanner scanner = new Scanner(System.in);
        
        String inputUser = null;
        String inputPassword = null;
        System.out.println("\nPlease set the admin credentials for this web application");
        while (true) {
            System.out.print("user: ");
            try{
	            inputUser = scanner.nextLine(); 
	            System.out.print("password: ");
	            inputPassword = scanner.nextLine();
	            System.out.print("confirm password: ");
            }
            catch(NoSuchElementException noex){
            	System.err.println("\nPlease restart the application manually ");
            	System.err.println("Unable to execute restart via spring devtools: ".concat(noex.getMessage()));
            	System.exit(1);
            }
            String inputPasswordConfirm = scanner.nextLine();
            

            if (inputUser.isEmpty()) {
                System.out.println("Error: user must be set - please try again");
            } else if (inputPassword.isEmpty()) {
                System.out.println("Error: password must be set - please try again");
            } else if (!inputPassword.equals(inputPasswordConfirm)) {
                System.out.println("Error: password and password confirm do not match - please try again");
            } else {
                LOG.info("Setting the in-memory security using the provided credentials...");
                break;
            }
            System.out.println("");
        }
        scanner.close();

        if (inputUser != null && inputPassword != null) {
             auth.inMemoryAuthentication()
                .withUser(inputUser)
                .password(inputPassword)
                .roles("USER");
        }
    }
}
