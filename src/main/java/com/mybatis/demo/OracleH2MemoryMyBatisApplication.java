package com.mybatis.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=production"
 * mvn spring-boot:run -Drun.jvmArguments="-Xdebug
 * -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005
 * -Dspring.profiles.active=jpa"
 * 
 * @author Michael Somers, mike1somers@gmail.com
 *
 */

@SpringBootApplication
@ComponentScan("com.mybatis.demo")
public class OracleH2MemoryMyBatisApplication {

	private static final Logger logger = LoggerFactory.getLogger(OracleH2MemoryMyBatisApplication.class);

	public static void main(String[] args) {

		logger.debug("Stating...");
		SpringApplication.run(OracleH2MemoryMyBatisApplication.class, args);
		logger.debug("Success!");
	}

}
