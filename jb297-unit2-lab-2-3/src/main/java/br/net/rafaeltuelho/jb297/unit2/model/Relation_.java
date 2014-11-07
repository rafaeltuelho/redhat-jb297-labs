package br.net.rafaeltuelho.jb297.unit2.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-06T17:40:20.926-0300")
@StaticMetamodel(Relation.class)
public class Relation_ {
	public static volatile SingularAttribute<Relation, String> type;
	public static volatile ListAttribute<Relation, Person> persons;
}
