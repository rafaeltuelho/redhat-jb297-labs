package br.net.rafaeltuelho.jb297.unit2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the relation database table.
 * 
 */
@Entity
@Table(name="relation", schema="TEST")
@NamedQuery(name="Relation.findAll", query="SELECT r FROM Relation r")
public class Relation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=25)
	private String type;

	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="relationBean")
	private List<Person> persons;

	public Relation() {
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person addPerson(Person person) {
		getPersons().add(person);
		person.setRelationBean(this);

		return person;
	}

	public Person removePerson(Person person) {
		getPersons().remove(person);
		person.setRelationBean(null);

		return person;
	}

	@Override
	public String toString() {
		return this.type;
	}

}