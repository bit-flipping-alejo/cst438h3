package cst438.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.http.HttpStatus;

import cst438.service.City;
import cst438.service.CityInfo;
import cst438.service.CityService;
import cst438.service.Country;
import cst438.service.TimeAndTemp;





@WebMvcTest(CityRestController.class)
public class CityRestControllerTest {
   
   @MockBean
   private CityService cityServ;
   
   
   @Autowired
   private MockMvc mvc;

   // These objects will be magically initialized by the initFields method below.
   private JacksonTester<CityInfo> JSONCityInfo;

   @BeforeEach
   public void setup() {
       JacksonTester.initFields(this, new ObjectMapper());
   }
   
   @Test
   public void getMiamiTestOK() throws Exception {
      
      City testCity = new City(3839, "Miami", "USA", "Florida", 362470);
      Country testCountry = new Country("USA", "United States", "North America", "North America", (long) 9363520.00, (long) 278357000.0 );
      TimeAndTemp tnt = new TimeAndTemp(73, 123, 45);
      
      given(cityServ.getCountryInfo("USA") ).willReturn(testCountry);            
      given( cityServ.getCityInfo("Miami") ).willReturn(testCity);
      given( cityServ.getWeatherInfo("Miami")).willReturn(tnt);
      
      CityInfo TestCityInfo = new CityInfo();
      TestCityInfo.setName( testCity.getName() );
      TestCityInfo.setCountryCode( testCity.getCountryCode() );
      TestCityInfo.setDistrict( testCity.getDistrict() );
      TestCityInfo.setTemp( (tnt.getTemp() - 273.15) * (9.0/5.0) + 32.0 );
      TestCityInfo.setTimezone( tnt.getTimezone() );
      TestCityInfo.setRegion( testCountry.getRegion() );
      TestCityInfo.setPopulation( testCity.getPopulation() );
      
      //from the abovce make this
      //CityInfo miamiInfo = ""
      
      // then set this up
      MockHttpServletResponse response = mvc.perform( get("/api/cities/Miami").accept(MediaType.APPLICATION_JSON) ).andReturn().getResponse();
      
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(JSONCityInfo.write(TestCityInfo).getJson());  
   }
   
   
   @Test
   public void getMiamiBAD() throws Exception {
      
      //from the abovce make this
      //CityInfo miamiInfo = ""
      
      // then set this up
      MockHttpServletResponse response = mvc.perform( get("/api/cities/Miai")
            .accept(MediaType.APPLICATION_JSON) ).andReturn().getResponse();
      
      assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
       
   }
   
   @Test
   public void getDoubleCity() throws Exception {
      
      City testCity = new City(568, "Los Angeles", "CHL", "Biobio", 158215);
      Country testCountry = new Country("CHL", "Chile", "South America", "South America", (long) 756626.00, (long) 15211000 );
      TimeAndTemp tnt = new TimeAndTemp(73, 123, 45);
      
      given(cityServ.getCountryInfo("CHL") ).willReturn(testCountry);            
      given( cityServ.getCityInfo("Los Angeles") ).willReturn(testCity);
      given( cityServ.getWeatherInfo("Los Angeles")).willReturn(tnt);
      
      CityInfo TestCityInfo = new CityInfo();
      TestCityInfo.setName( testCity.getName() );
      TestCityInfo.setCountryCode( testCity.getCountryCode() );
      TestCityInfo.setDistrict( testCity.getDistrict() );
      TestCityInfo.setTemp( (tnt.getTemp() - 273.15) * (9.0/5.0) + 32.0 );
      TestCityInfo.setTimezone( tnt.getTimezone() );
      TestCityInfo.setRegion( testCountry.getRegion() );
      TestCityInfo.setPopulation( testCity.getPopulation() );
      
      MockHttpServletResponse response = mvc.perform( get("/api/cities/Los Angeles").accept(MediaType.APPLICATION_JSON) ).andReturn().getResponse();
      
      assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.getContentAsString()).isEqualTo(JSONCityInfo.write(TestCityInfo).getJson());  
   }
   
   
   
   
   
   
}
