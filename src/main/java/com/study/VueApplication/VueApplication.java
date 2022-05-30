package com.study.VueApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages = {"com.study.VueApplication.Board.domain"})
//@EntityScan("com.study.VueApplication.Board.domain")
//@EnableJpaRepositories("com.study.VueApplication.Board.infra")
@SpringBootApplication
public class VueApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueApplication.class, args);
	}

}
