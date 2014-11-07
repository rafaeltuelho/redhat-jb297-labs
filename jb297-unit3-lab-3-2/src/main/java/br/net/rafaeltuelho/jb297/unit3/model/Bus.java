package br.net.rafaeltuelho.jb297.unit3.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bus
 *
 */
@Entity
@Table(schema="MAPPER")
public class Bus implements Serializable {

	@TableGenerator(name="bus_tab_gen", schema="MAPPER", table="SEQUENCES", 
			pkColumnName="SEQ_NAME", valueColumnName = "SEQ_VALUE", pkColumnValue = "BUS_SEQUENCE",
			initialValue=1, allocationSize=5)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="bus_tab_gen")
	private Long id;
	private String make;
	private String model;
	private String year;
	private static final long serialVersionUID = 1L;

	public Bus() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}   
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}   
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}
   
}
