package cst438.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cst438.service.City;
import cst438.service.CityService;
import cst438.service.Country;
import cst438.service.TimeAndTemp;

@Controller
public class CityController {
   
   @Autowired
   private CityService cityServ;
   
   
   @GetMapping("/cities/{city}")
   public String getCityInfo(@PathVariable("city") String cityName, Model model) {
      
      City targetcity = cityServ.getCityInfo(cityName);
      model.addAttribute("targetCity", targetcity);

      Country targetCountry = cityServ.getCountryInfo(targetcity.getCountryCode());
      model.addAttribute("targetCountry", targetCountry);
      
      TimeAndTemp targetTnT = cityServ.getWeatherInfo(cityName);
      targetTnT.setTemp( (targetTnT.getTemp()- 273.15) * (9.0/5.0) + 32.0);
      model.addAttribute("tnt", targetTnT);
      
      return "CityInfo";
   }
   
   @PostMapping("/cities/reservation")
   public String createReservation( @RequestParam("cityName") String cityName, 
         @RequestParam("typeOfTrip") String typeOfTrip, @RequestParam("emailInput") String emailInput, 
         Model model) {
      
      model.addAttribute("cityName", cityName);
      model.addAttribute("typeOfTrip", typeOfTrip);
      model.addAttribute("emailInput", emailInput);
      cityServ.requestReservation(cityName, typeOfTrip, emailInput);
      
      return "request_reservation";
   }
     
   
}












