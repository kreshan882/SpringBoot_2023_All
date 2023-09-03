package com.kre.springfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan

@SpringBootConfiguration  (tested this is main spring boot application)
@EnableAutoConfiguration(exclude(hivernet)) //Hibernet can exclude from @SpringBootApplication
@ComponentScan(all the controller class added) // on old spring framework, manually added
 */
@SpringBootApplication
public class S1SpringLearnFullDcbApplication {

	public static void main(String[] args) {
		SpringApplication.run(S1SpringLearnFullDcbApplication.class, args);
	}

}
