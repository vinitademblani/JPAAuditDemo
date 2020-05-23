package com.example.JPAAuditingDemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaAuditingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAuditingDemoApplication.class, args);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       Date dateobj = new Date();
	       System.out.println("Current date is ===="+dateobj);
	       System.out.println("-------");
	       System.out.println(df.format(dateobj)); //get in String format
	       //ZoneId zone = ZoneId.of("America/New_York");
	       System.out.println(dateobj.toInstant()); //converting again to UTC 
	   
	}

}
