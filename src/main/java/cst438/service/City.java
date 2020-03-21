package cst438.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class City {

   @Id
   @GeneratedValue
   private long id;
   
   @NotNull
   @Size(min=3, max=50) 
   private String name;
   
   @NotNull
   @Size(min=3, max=50) 
   @Column(name="countrycode")
   private String countryCode; 
  
   @NotNull
   @Size(min=3, max=50) 
   private String district;
   
   @NotNull
   private long population;
   
   
   public City() {
      
   }

   public City(long id, @NotNull @Size(min = 3, max = 50) String name,
         @NotNull @Size(min = 3, max = 50) String countryCode,
         @NotNull @Size(min = 3, max = 50) String district,
         @NotNull long population) {
      super();
      this.id = id;
      this.name = name;
      this.countryCode = countryCode;
      this.district = district;
      this.population = population;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCountryCode() {
      return countryCode;
   }

   public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
   }

   public String getDistrict() {
      return district;
   }

   public void setDistrict(String district) {
      this.district = district;
   }

   public long getPopulation() {
      return population;
   }

   public void setPopulation(long population) {
      this.population = population;
   }

   
   // Equals
   @Override
   public boolean equals (Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      
      City other = (City) obj;
      
      if (!other.name.equals(name) )
         return false;
      if (!other.countryCode.equals(countryCode))
         return false;
      if (!other.district.equals(district))
         return false;
      if (other.population != (population))
         return false;      
      return true;
   }
   
   
   
   
   
   
}



















