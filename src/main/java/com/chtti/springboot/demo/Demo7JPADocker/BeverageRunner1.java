package com.chtti.springboot.demo.Demo7JPADocker;

import com.chtti.springboot.demo.Demo7JPADocker.beans.Beverage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeverageRunner1 implements CommandLineRunner {
    public static final Logger LOGGER = LoggerFactory.getLogger(BeverageRunner1.class.getSimpleName());
    @Autowired
    MyBeverageCRUDRepository repository;
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("start to rest beverage repository");
        insertSomeDate();
        loadAllData();
        deleteAndCheckOut();
    }
    private void deleteAndCheckOut(){
        LOGGER.info("before delete, count={}",repository.count());
        repository.deleteAll();
        LOGGER.info("aftor delete, count={}",repository.count());
    }

    private void loadAllData(){
        repository.findAll().forEach(beverage -> LOGGER.info("get a recond==>{}",beverage));
    }

    private void insertSomeDate(){
        repository.save(new Beverage("americano","black coffee witn no milk"));
        repository.save(new Beverage("latte","espresso with 60% milk"));
        repository.save(new Beverage("Assam black tea","nomral black twa"));
    }
}
