package com.cg.demo.service.impl;

import com.cg.demo.model.City;
import com.cg.demo.repository.CityRepository;
import com.cg.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityService implements BaseService<City> {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City object) {
        cityRepository.save(object);
    }

    @Override
    public Optional<City> findById(long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void remove(long id) {
        cityRepository.deleteById(id);
    }
}
