package com.cg.demo.controller.rest;

import com.cg.demo.model.City;
import com.cg.demo.service.impl.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;
    @GetMapping("/cities")
    public List<City> cities(){
        return cityService.findAll();
    }


    @GetMapping("/cities/{id}")
    public Optional<City> cities(@PathVariable long id){
        return cityService.findById(id);
    }

    @PostMapping("/cities")
    public City add(@RequestBody City city){
        cityService.save(city);
        return city;
    }

    @PatchMapping("/cities")
    public City put(@RequestBody City city){
        cityService.save(city);
        return city;
    }

    @DeleteMapping("/cities/{id}")
    public void delete(@PathVariable long id){
        cityService.remove(id);
    }


    @DeleteMapping("/cities-remove/{id}")
    public ResponseEntity<City> deleteHttpStatus(@PathVariable long id){
        cityService.remove(id);
        return new ResponseEntity<City>(HttpStatus.OK);
    }
}
