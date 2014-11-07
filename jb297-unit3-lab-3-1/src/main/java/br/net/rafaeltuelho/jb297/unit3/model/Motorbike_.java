package br.net.rafaeltuelho.jb297.unit3.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-23T18:22:01.314-0300")
@StaticMetamodel(Motorbike.class)
public class Motorbike_ {
	public static volatile SingularAttribute<Motorbike, Long> id;
	public static volatile SingularAttribute<Motorbike, BigDecimal> engine_size;
	public static volatile SingularAttribute<Motorbike, String> color;
	public static volatile SingularAttribute<Motorbike, Boolean> operational_ind;
}
