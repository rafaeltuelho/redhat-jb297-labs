package br.net.rafaeltuelho.jb297.unit2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name = "person", schema = "TEST")
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name="PERSON_SEQ", sequenceName="TEST.PERSON_SEQ", allocationSize=1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PERSON_SEQ")
   @Column(unique = true, nullable = false, updatable=false)
   private Integer uid;

   @Column(nullable = false, length = 25)
   private String firstname;

   @Column(nullable = false, length = 25)
   private String lastname;

   //bi-directional one-to-one association to Address
   @OneToOne(mappedBy = "person")
   private Address address;

   //bi-directional many-to-one association to Relation
   @ManyToOne
   @JoinColumn(name = "relation", nullable = false)
   private Relation relationBean;

   public Person()
   {
   }

   public Integer getUid()
   {
      return this.uid;
   }

   public void setUid(Integer uid)
   {
      this.uid = uid;
   }

   public String getFirstname()
   {
      return this.firstname;
   }

   public void setFirstname(String firstname)
   {
      this.firstname = firstname;
   }

   public String getLastname()
   {
      return this.lastname;
   }

   public void setLastname(String lastname)
   {
      this.lastname = lastname;
   }

   public Address getAddress()
   {
      return this.address;
   }

   public void setAddress(Address address)
   {
      this.address = address;
   }

   public Relation getRelationBean()
   {
      return this.relationBean;
   }

   public void setRelationBean(Relation relationBean)
   {
      this.relationBean = relationBean;
   }

   public void newAddress()
   {
      this.address = new Address();
   }

}