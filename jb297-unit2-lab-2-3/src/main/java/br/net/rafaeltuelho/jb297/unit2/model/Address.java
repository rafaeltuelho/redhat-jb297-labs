package br.net.rafaeltuelho.jb297.unit2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "address", schema = "TEST")
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @Column(unique = true, nullable = false)
   private Integer uid;

   @Column(nullable = false, length = 30)
   private String city;

   @Column(nullable = false, length = 25)
   private String country;

   @Column(name = "state_prov", nullable = false, length = 25)
   private String stateProv;

   @Column(nullable = false, length = 40)
   private String street;

   @Column(name = "zip_post", nullable = false, length = 10)
   private String zipPost;

   //bi-directional one-to-one association to Person
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "uid", nullable = false, insertable = false, updatable = false)
   private Person person;

   public Address()
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

   public String getCity()
   {
      return this.city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   public String getCountry()
   {
      return this.country;
   }

   public void setCountry(String country)
   {
      this.country = country;
   }

   public String getStateProv()
   {
      return this.stateProv;
   }

   public void setStateProv(String stateProv)
   {
      this.stateProv = stateProv;
   }

   public String getStreet()
   {
      return this.street;
   }

   public void setStreet(String street)
   {
      this.street = street;
   }

   public String getZipPost()
   {
      return this.zipPost;
   }

   public void setZipPost(String zipPost)
   {
      this.zipPost = zipPost;
   }

   public Person getPerson()
   {
      return this.person;
   }

   public void setPerson(Person person)
   {
      this.person = person;
   }

   public void newPerson()
   {
      this.person = new Person();
   }

}