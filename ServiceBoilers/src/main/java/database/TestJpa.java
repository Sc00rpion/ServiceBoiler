package database;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entity.Boiler;

public class TestJpa {
	
	   public static void main(String[] args) {
		   ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
		   BoilerRepository rep = context.getBean(BoilerRepository.class);
		   rep.save(new Boiler("kocio³", new Date(19999999999l)));
		   Iterable<Boiler> boilers = rep.findAll();
		   for (Boiler boiler : boilers) {
			System.out.println(boiler);
		}
		   }


}
