package cst438.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Country {

   @NotNull
   @Id
   @Column(name = "Code")
   private String code;
   @NotNull
   @Column(name = "Name")
   private String name;
   @NotNull
   @Column(name = "continent")
   private String continent;
   
   @Column(name = "region")
   private String region;
   
   @Column(name = "surfacearea")
   private long surfaceArea;
   
   @Column(name = "population")
   private long population; 

   
   public Country() {
      
   }

   public Country(@NotNull String code, @NotNull String name,
         @NotNull String continent, String region, long surfaceArea,
         long population) {
      super();
      this.code = code;
      this.name = name;
      this.continent = continent;
      this.region = region;
      this.surfaceArea = surfaceArea;
      this.population = population;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getContinent() {
      return continent;
   }

   public void setContinent(String continent) {
      this.continent = continent;
   }

   public String getRegion() {
      return region;
   }

   public void setRegion(String region) {
      this.region = region;
   }

   public long getSurfaceArea() {
      return surfaceArea;
   }

   public void setSurfaceArea(long surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public long getPopulation() {
      return population;
   }

   public void setPopulation(long population) {
      this.population = population;
   }


   @Override
   public boolean equals (Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      
      Country other = (Country) obj;
      
      if (!other.code.equals(code))
         return false;
      if (!other.name.equals(name))
         return false;
      if (!other.continent.equals(continent))
         return false;
      if (!other.region.equals(region))
         return false;
      if (other.surfaceArea != surfaceArea)
         return false;
      if (other.population != population)
         return false;
      
      return true;
      
   }

   
   
   
}
