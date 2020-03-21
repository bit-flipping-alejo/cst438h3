package cst438.service;

import java.util.List;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
   
   // HW3 additions
   @Autowired
   private RabbitTemplate rabbitTemp;
   
   @Autowired
   private FanoutExchange fanout;
   
   
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
   
   
   public void requestReservation(String cityName,String typeOfTrip, String emailInput) {
      System.out.println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<");
      System.out.println("City Name: " + cityName);
      System.out.println("");
      System.out.println("Type of trip: " + typeOfTrip);
      System.out.println("");
      System.out.println("Email Input: " + emailInput);
      System.out.println("");
      System.out.println(">>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<");
      
      
      String msg  = "{\"cityName\": \""+ cityName + "\" \"level\": \""+ typeOfTrip+
            "\" \"email\": \""+emailInput+"\"}" ;
      System.out.println("Sending message:"+msg);
      rabbitTemp.convertSendAndReceive(fanout.getName(), "", msg);
      
   }
   
   
}






















