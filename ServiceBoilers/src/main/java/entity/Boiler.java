package entity;

import java.sql.Date;

public class Boiler {
	private final Long id;
	private String name;
	private Date launchDate;
	
	public Boiler(String name, Date launchDate){
		this(null, name, launchDate);
	}
	
	public Boiler(Long id, String name, Date launchDate){
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
