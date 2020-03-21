package cst438.service;

public class CityInfo {
   
   private String name;
   private String countryCode;
   private String district;
   private double temp;
   private int timezone;
   private String region;
   private long population;
   
   public CityInfo() {
      
   }
   
   public CityInfo(String name, String countryCode, String district,
         double temp, int timezone, String region, long population) {
      super();
      this.name = name;
      this.countryCode = countryCode;
      this.district = district;
      this.temp = temp;
      this.timezone = timezone;
      this.region = region;
      this.population = population;
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
   public double getTemp() {
      return temp;
   }
   public void setTemp(double temp) {
      this.temp = temp;
   }
   public int getTimezone() {
      return timezone;
   }
   public void setTimezone(int timezone) {
      this.timezone = timezone;
   }
   public String getRegion() {
      return region;
   }
   public void setRegion(String region) {
      this.region = region;
   }
   public long getPopulation() {
      return population;
   }
   public void setPopulation(long population) {
      this.population = population;
   } 
   
   
   
}
