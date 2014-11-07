package br.net.rafaeltuelho.jb297.unit3.model;

import java.io.Serializable;
import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity
@Table(schema="MAPPER", name="SPEEDING_TICKET")
@IdClass(TicketKey.class)
public class Ticket implements Serializable {

	@Id
	private String licensenbr;
	@TableGenerator(name="ticket_tab_gen", schema="MAPPER", table="SEQUENCES", 
			pkColumnName="SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "TICKET_SEQUENCE",
			initialValue=1, allocationSize=5)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="ticket_tab_gen")
	private BigInteger ticketnbr;
	
	@Column(name="fine_amt", updatable=false)
	private BigDecimal fineAmount;
	private static final long serialVersionUID = 1L;

	public Ticket() {
		super();
	}   
	public String getLicensenbr() {
		return this.licensenbr;
	}

	public void setLicensenbr(String licensenbr) {
		this.licensenbr = licensenbr;
	}   
	public BigInteger getTicketnbr() {
		return this.ticketnbr;
	}

	public void setTicketnbr(BigInteger ticketnbr) {
		this.ticketnbr = ticketnbr;
	}   
	public BigDecimal getFine_amt() {
		return this.fineAmount;
	}

	public void setFine_amt(BigDecimal fine_amt) {
		this.fineAmount = fine_amt;
	}
   
}
