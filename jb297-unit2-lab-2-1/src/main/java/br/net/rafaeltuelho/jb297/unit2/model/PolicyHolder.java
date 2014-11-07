package br.net.rafaeltuelho.jb297.unit2.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PolicyHolder
 *
 */
@Entity
public class PolicyHolder implements Serializable {

	@Id
	private Long id;
	private String name;
	private Integer age;
	private BigDecimal policy_amount;
	private static final long serialVersionUID = 1L;

	public PolicyHolder() {
		super();
	}   
	
	public PolicyHolder(Long id, String name, Integer age,
			BigDecimal policy_amount) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.policy_amount = policy_amount;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}   
	public BigDecimal getPolicy_amount() {
		return this.policy_amount;
	}

	public void setPolicy_amount(BigDecimal policy_amount) {
		this.policy_amount = policy_amount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PolicyHolder [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", policy_amount=");
		builder.append(policy_amount);
		builder.append("]");
		return builder.toString();
	}
   
}
