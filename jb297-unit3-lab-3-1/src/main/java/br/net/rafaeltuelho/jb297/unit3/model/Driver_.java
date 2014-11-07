package br.net.rafaeltuelho.jb297.unit3.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-23T18:29:06.729-0300")
@StaticMetamodel(Driver.class)
public class Driver_ {
	public static volatile SingularAttribute<Driver, Long> id;
	public static volatile SingularAttribute<Driver, String> licensenbr;
	public static volatile SingularAttribute<Driver, String> firstname;
	public static volatile SingularAttribute<Driver, String> lastname;
	public static volatile SingularAttribute<Driver, String> mi;
	public static volatile SingularAttribute<Driver, Timestamp> dob;
	public static volatile SingularAttribute<Driver, Timestamp> license_issued;
	public static volatile SingularAttribute<Driver, Integer> nbr_tickets;
}
