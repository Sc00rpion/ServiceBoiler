package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue
	private long addressId;
	private String city;
	private String postalCode;
	private String street;
	private String streetNumber;

}
