package br.net.rafaeltuelho.jb297.unit3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Driver
 *
 */
@Entity
@Table(schema="MAPPER")
public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	private Long id;
	private String licensenbr;
	private String firstname;
	private String middleInitial;
	private String lastname;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private String mi;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="license_issued")
	@Temporal(TemporalType.TIMESTAMP)
	private Date issued;
	
	private Integer nbr_tickets;

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
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}   
	public Date getIssued() {
		return this.issued;
	}

	public void setIssued(Date license_issued) {
		this.issued = license_issued;
	}   
	public Integer getNbr_tickets() {
		return this.nbr_tickets;
	}

	public void setNbr_tickets(Integer nbr_tickets) {
		this.nbr_tickets = nbr_tickets;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
   
}
