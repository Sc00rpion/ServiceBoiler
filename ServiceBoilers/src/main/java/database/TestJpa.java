package database;

import java.sql.Date;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entity.Address;
import entity.Boiler;
import entity.Service;

public class TestJpa {
	
	   public static void main(String[] args) {
		   ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
		   BoilerRepository rep = context.getBean(BoilerRepository.class);
		   
		   Address a1 = new Address();
		   Boiler b1 = new Boiler("kocio³", new Date(19999999999l),a1);
		   Set<Service> s1 = b1.getService();
		   s1.add(new Service(new Date(3000000000l)));
		   s1.add(new Service(new Date(1000000000l)));
		   s1.add(new Service(new Date(2000000000l)));
		   rep.save(b1);
		   Address a2 = new Address();
		   a2.setCity("warszawa");
		   Boiler b2 = new Boiler("kocio³", new Date(19999999999l),a2);
		   Set<Service> s2 = b2.getService();
		   s2.add(new Service(new Date(3000000000l)));
		   s2.add(new Service(new Date(4000000000l)));
		   rep.save(b2);		 
		   Iterable<Boiler> boilers = rep.findByService(new Date(3500000000l),new Date(5000000000l));
		   for (Boiler boiler : boilers) {
			System.out.println(boiler);
		}
		   }


}
