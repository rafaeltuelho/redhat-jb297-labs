package br.net.rafaeltuelho.jb297.unit3.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-21T21:32:13.995-0300")
@StaticMetamodel(PolicyHolder.class)
public class PolicyHolder_ {
	public static volatile SingularAttribute<PolicyHolder, Long> id;
	public static volatile SingularAttribute<PolicyHolder, String> name;
	public static volatile SingularAttribute<PolicyHolder, Integer> age;
	public static volatile SingularAttribute<PolicyHolder, BigDecimal> policy_amount;
}
