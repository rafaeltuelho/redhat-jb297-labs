package br.net.rafaeltuelho.jb297.unit3.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Driver
 *
 */
@Entity
@Table(schema="MAPPER")
public class Driver implements Serializable {

	   
	@Id
	private Long id;
	private String licensenbr;
	private String firstname;
	private String lastname;
	private String mi;
	private Timestamp dob;
	private Timestamp license_issued;
	private Integer nbr_tickets;
	private static final long serialVersionUID = 1L;

	public Driver() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getLicensenbr() {
		return this.licensenbr;
	}

	public void setLicensenbr(String licensenbr) {
		this.licensenbr = licensenbr;
	}   
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}   
	public String getMi() {
		return this.mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}   
	public Timestamp getDob() {
		return this.dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}   
	public Timestamp getLicense_issued() {
		return this.license_issued;
	}

	public void setLicense_issued(Timestamp license_issued) {
		this.license_issued = license_issued;
	}   
	public Integer getNbr_tickets() {
		return this.nbr_tickets;
	}

	public void setNbr_tickets(Integer nbr_tickets) {
		this.nbr_tickets = nbr_tickets;
	}
   
}
