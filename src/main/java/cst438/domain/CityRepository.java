package cst438.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cst438.service.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

   @Query(value="Select * from City where name = ?1", nativeQuery=true)
   List<City> findByName(String name);   
   
}
