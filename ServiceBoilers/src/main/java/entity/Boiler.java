package entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boiler {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	public void setId(long id) {
		this.id = id;
	}

	private String name;
	private Date launchDate;
	
	public Boiler(){
	}
	
	public Boiler(String name, Date launchDate){
		this.name = name;
		this.launchDate = launchDate;
	}
	
	public Boiler(long id, String name, Date launchDate){
		this.id = id;
		this.name = name;
		this.launchDate = launchDate;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	@Override
	public String toString() {
		return "Boiler [id=" + id + ", name=" + name + ", launchDate=" + launchDate + "]";
	}

}
