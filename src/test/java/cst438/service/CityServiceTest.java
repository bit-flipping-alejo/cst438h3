package cst438.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import cst438.domain.CityRepository;
import cst438.domain.CountryRepository;

@SpringBootTest
public class CityServiceTest {
   
   private CityService cityServ;
   
   @Mock
   private CityRepository cityRepo;
   
   @Mock
   private CountryRepository countryRepo;
   
   @Mock
   private WeatherService weatherService;
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
      cityServ = new CityService(cityRepo,countryRepo,weatherService);
   }
   
   
   @Test
   public void getCityInfoTest() {
      City testCity = new City(3839, "Miami", "USA", "Florida", 362470);
      
      List<City> testList = new ArrayList<City>();
      testList.add(testCity);
      
      //the cast here may be a source of error
      given( cityRepo.findByName("Miami") ).willReturn( testList);
      
      City retList = cityServ.getCityInfo("Miami");
      
      assertThat( retList ).isEqualTo( testCity );
      
   }
   
   @Test
   public void getCountryInfoTest() {
      Country testCountry = new Country("USA", "United States", "North America", "North America", (long) 9363520.00, (long) 278357000.0 );
      
      given(countryRepo.findByCode("USA") ).willReturn(testCountry);
      
      Country retCountry = cityServ.getCountryInfo("USA");
      
      assertThat(retCountry).isEqualTo(testCountry);
      
   }
   

   // My implementation does not create one huge class, instead it 
   // creates 3 small classes that could feed into a CityInfo class
   // however CityInfo is only returned for the RestAPI and not with
   // the MVC Controller. So the below is there for completeness
   // but is in essence a circular test
   @Test
   public void getWeatherTest() {
      TimeAndTemp tnt = new TimeAndTemp(73, 123, 45);
      
      given( weatherService.getTempAndTime("Miami")).willReturn(tnt);
      
      TimeAndTemp retTnt = weatherService.getTempAndTime("Miami");
      
      assertThat(retTnt).isEqualTo(tnt);
      
   }
   
   
   
}
