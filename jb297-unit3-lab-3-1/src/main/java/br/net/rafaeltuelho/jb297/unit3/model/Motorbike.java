package br.net.rafaeltuelho.jb297.unit3.model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Motorbike
 *
 */
@Entity
@Table(schema="MAPPER", name="MOTORCYCLE")
public class Motorbike implements Serializable {

	   
	@TableGenerator(name="motor_tab_gen", schema="MAPPER", table="SEQUENCES", 
			pkColumnName="SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "VEHICLE_SEQUENCE",
			initialValue=1, allocationSize=5)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="motor_tab_gen")
	private Long id;
	private BigDecimal engine_size;
	private String color;
	private Boolean operational_ind;
	private static final long serialVersionUID = 1L;

	public Motorbike() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public BigDecimal getEngine_size() {
		return this.engine_size;
	}

	public void setEngine_size(BigDecimal engine_size) {
		this.engine_size = engine_size;
	}   
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}   
	public Boolean getOperational_ind() {
		return this.operational_ind;
	}

	public void setOperational_ind(Boolean operational_ind) {
		this.operational_ind = operational_ind;
	}
   
}
