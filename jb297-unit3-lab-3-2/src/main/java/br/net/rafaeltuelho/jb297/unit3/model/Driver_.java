package br.net.rafaeltuelho.jb297.unit3.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-01T17:51:41.040-0300")
@StaticMetamodel(Driver.class)
public class Driver_ {
	public static volatile SingularAttribute<Driver, Long> id;
	public static volatile SingularAttribute<Driver, String> licensenbr;
	public static volatile SingularAttribute<Driver, String> firstname;
	public static volatile SingularAttribute<Driver, String> middleInitial;
	public static volatile SingularAttribute<Driver, String> lastname;
	public static volatile SingularAttribute<Driver, Date> birthDate;
	public static volatile SingularAttribute<Driver, String> mi;
	public static volatile SingularAttribute<Driver, Date> dob;
	public static volatile SingularAttribute<Driver, Date> issued;
	public static volatile SingularAttribute<Driver, Integer> nbr_tickets;
}
