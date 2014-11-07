package br.net.rafaeltuelho.jb297.unit3.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-23T18:41:41.851-0300")
@StaticMetamodel(Ticket.class)
public class Ticket_ {
	public static volatile SingularAttribute<Ticket, String> licensenbr;
	public static volatile SingularAttribute<Ticket, BigInteger> ticketnbr;
	public static volatile SingularAttribute<Ticket, BigDecimal> fine_amt;
}
