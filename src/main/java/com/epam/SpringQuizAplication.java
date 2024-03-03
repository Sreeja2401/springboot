package com.epam;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class SpringQuizAplication {

	@Bean
    public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("sreeja").createEntityManager();
	}

}
