package entity;

import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Boiler {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String owner;
	private String tel;
	private Date launchDate;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Service> service = new TreeSet<Service>();

	public Boiler() {
	}

	public Boiler(String name, Date launchDate, Address address) {
		this.name = name;
		this.launchDate = launchDate;
		this.address = address;
	}

	public Boiler(long id, String name, Date launchDate) {
		this.id = id;
		this.name = name;
		this.launchDate = launchDate;
	}

}
