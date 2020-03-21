package cst438.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cst438.domain.CityRepository;
//import cst348hw2.domain.CountryRepository;
import cst438.domain.CountryRepository;


@Service
public class CityService {
   @Autowired
   private CityRepository cityRepo;
   
   @Autowired
   private CountryRepository countryRepo;
   
   @Autowired
   private WeatherService weatherService;
   
   // This constructor is only going to be used for the testing
   public CityService(CityRepository cityRepo, CountryRepository countryRepo, WeatherService weatherService) {      
      this.cityRepo = cityRepo;
      this.countryRepo = countryRepo;
      this.weatherService = weatherService;
   }

   public City getCityInfo( String cityName) {  
      List<City> returnedList = cityRepo.findByName(cityName);           
      return returnedList.get(0);
      
   }
   
   public Country getCountryInfo( String countryCode) {
      return countryRepo.findByCode(countryCode);      
   }
   
   public TimeAndTemp getWeatherInfo(String cityName) {
      return weatherService.getTempAndTime(cityName);
   }
   
   
}
