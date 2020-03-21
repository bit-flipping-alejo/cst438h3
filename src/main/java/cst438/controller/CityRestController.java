package cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cst438.service.City;
import cst438.service.CityInfo;
import cst438.service.CityService;
import cst438.service.Country;
import cst438.service.TimeAndTemp;
//import cst438.service.WeatherService;

@RestController
public class CityRestController {

   @Autowired
   private CityService cityServ;
   
   @GetMapping("/api/cities/{city}")
   public CityInfo getWeather(@PathVariable("city") String cityName) {
      try {
         
         City targetcity = cityServ.getCityInfo(cityName);
         Country targetCountry = cityServ.getCountryInfo(targetcity.getCountryCode());
         TimeAndTemp targetTnT = cityServ.getWeatherInfo(cityName);
         
         CityInfo tgtCI = new CityInfo();
   
         tgtCI.setName( cityName );
         tgtCI.setCountryCode( targetcity.getCountryCode() );
         tgtCI.setDistrict( targetcity.getDistrict() );
         tgtCI.setTemp( (targetTnT.getTemp() - 273.15) * (9.0/5.0) + 32.0 );
         tgtCI.setTimezone( targetTnT.getTimezone() );
         tgtCI.setRegion( targetCountry.getRegion() );
         tgtCI.setPopulation( targetcity.getPopulation() );
   
         return tgtCI;
         
      } catch (Exception e) {
         throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Could not get City Info" );
         
      }
      
      
   }
   
}
