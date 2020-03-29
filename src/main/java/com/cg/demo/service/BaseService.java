package com.cg.demo.service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    List<T> findAll();
    void save(T object);
    Optional<T> findById(long id);
    void remove(long id);
}
