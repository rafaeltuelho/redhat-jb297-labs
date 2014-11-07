package br.net.rafaeltuelho.jb297.unit3.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-01T17:51:41.053-0300")
@StaticMetamodel(Motorbike.class)
public class Motorbike_ {
	public static volatile SingularAttribute<Motorbike, Long> id;
	public static volatile SingularAttribute<Motorbike, BigDecimal> engineSize;
	public static volatile SingularAttribute<Motorbike, ColorNames> color;
	public static volatile SingularAttribute<Motorbike, Boolean> operational;
}
