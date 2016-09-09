package database;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entity.Boiler;

public class TestJdbc {
	
	   public static void main(String[] args) {
		   ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
		   JdbcBoilerRepository rep = context.getBean(JdbcBoilerRepository.class);
		   List<Boiler> boilers = rep.getBoilers();
		   for (Boiler boiler : boilers) {
			System.out.println(boiler);
		}
		   }


}
