package cst438.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cst438.service.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

   @Query(value="SELECT * FROM Country WHERE Code =  ?1", nativeQuery=true)
   Country findByCode(String code);
}
