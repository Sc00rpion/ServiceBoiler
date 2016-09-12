package entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Service implements Comparable<Service> {

	@Id
	@GeneratedValue
	private long serviceId;
	private Date dateOfService;

	public Service() {
	}

	public Service(Date dateOfService) {
		super();
		this.dateOfService = dateOfService;
	}

	public int compareTo(Service o) {
		return this.dateOfService.compareTo(o.dateOfService);
	}
}
