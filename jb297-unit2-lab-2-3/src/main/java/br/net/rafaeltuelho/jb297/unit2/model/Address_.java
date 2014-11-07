package br.net.rafaeltuelho.jb297.unit2.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-06T17:40:20.924-0300")
@StaticMetamodel(Address.class)
public class Address_ {
	public static volatile SingularAttribute<Address, Integer> uid;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> stateProv;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> zipPost;
	public static volatile SingularAttribute<Address, Person> person;
}
