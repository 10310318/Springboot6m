package com.chtti.springboot.demo.Demo7JPADocker;

import com.chtti.springboot.demo.Demo7JPADocker.beans.Beverage;
import org.springframework.data.repository.CrudRepository;

public interface MyBeverageCRUDRepository extends CrudRepository<Beverage,Long> {
    
}
