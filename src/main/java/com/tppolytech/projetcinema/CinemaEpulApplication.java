package com.tppolytech.projetcinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication ( exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan("com.tppolytech")
public class CinemaEpulApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaEpulApplication.class, args);
	}
}
