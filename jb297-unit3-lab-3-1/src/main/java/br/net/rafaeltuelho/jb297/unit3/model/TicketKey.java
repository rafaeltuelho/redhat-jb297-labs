package br.net.rafaeltuelho.jb297.unit3.model;

import java.io.Serializable;
import java.math.BigInteger;

public class TicketKey implements Serializable{
	private static final long serialVersionUID = -7280859764157201126L;

	private String licensenbr;
	private BigInteger ticketnbr;

	public TicketKey(){
		
	}
	
	public String getLicensenbr() {
		return licensenbr;
	}

	public void setLicensenbr(String licensenbr) {
		this.licensenbr = licensenbr;
	}

	public BigInteger getTicketnbr() {
		return ticketnbr;
	}

	public void setTicketnbr(BigInteger ticketnbr) {
		this.ticketnbr = ticketnbr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((licensenbr == null) ? 0 : licensenbr.hashCode());
		result = prime * result
				+ ((ticketnbr == null) ? 0 : ticketnbr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TicketKey)) {
			return false;
		}
		TicketKey other = (TicketKey) obj;
		if (licensenbr == null) {
			if (other.licensenbr != null) {
				return false;
			}
		} else if (!licensenbr.equals(other.licensenbr)) {
			return false;
		}
		if (ticketnbr == null) {
			if (other.ticketnbr != null) {
				return false;
			}
		} else if (!ticketnbr.equals(other.ticketnbr)) {
			return false;
		}
		return true;
	}

}
