package com.chtti.springboot.demo.Demo7JPADocker;

import com.chtti.springboot.demo.Demo7JPADocker.beans.Beverage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

@SpringBootApplication
public abstract class Demo7JpaDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo7JpaDockerApplication.class, args);
	}
	public abstract List<Beverage> findMathbyTitle(String tilte);

}
