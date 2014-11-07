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

	private static final long serialVersionUID = 1L;
   
	@TableGenerator(name="motor_tab_gen", schema="MAPPER", table="SEQUENCES", 
			pkColumnName="SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "VEHICLE_SEQUENCE",
			initialValue=1, allocationSize=5)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="motor_tab_gen")
	private Long id;
	
	@Column(name="engine_size")
	private BigDecimal engineSize;
	
	@Enumerated(EnumType.STRING)
	private ColorNames color;
	
	@Column(name="operational_ind")
	private Boolean operational;
	
	
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
		return this.engineSize;
	}

	public void setEngine_size(BigDecimal engine_size) {
		this.engineSize = engine_size;
	}   
	public ColorNames getColor() {
		return this.color;
	}

	public void setColor(ColorNames color) {
		this.color = color;
	}   
	
	public Boolean isOperational() {
		return this.operational;
	}

	public void setOperational(Boolean isOperational) {
		this.operational = isOperational;
	}
   
}
