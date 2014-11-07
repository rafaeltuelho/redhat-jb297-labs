package br.net.rafaeltuelho.jb297.unit2.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-06T17:40:20.925-0300")
@StaticMetamodel(Person.class)
public class Person_ {
	public static volatile SingularAttribute<Person, Integer> uid;
	public static volatile SingularAttribute<Person, String> firstname;
	public static volatile SingularAttribute<Person, String> lastname;
	public static volatile SingularAttribute<Person, Address> address;
	public static volatile SingularAttribute<Person, Relation> relationBean;
}
