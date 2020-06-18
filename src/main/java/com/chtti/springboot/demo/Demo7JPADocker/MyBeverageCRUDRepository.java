package com.chtti.springboot.demo.Demo7JPADocker;

import com.chtti.springboot.demo.Demo7JPADocker.beans.Beverage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyBeverageCRUDRepository extends CrudRepository<Beverage,Long> {
    public List<Beverage> findMatchByTitle(String title);
    List<Beverage> findByTitleLike(String title);
    Page<Beverage> findAll(Pageable pageable);
    List<Beverage> findByDetailContaining(String detail);
}
