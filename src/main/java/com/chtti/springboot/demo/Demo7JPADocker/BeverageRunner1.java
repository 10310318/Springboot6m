package com.chtti.springboot.demo.Demo7JPADocker;

import com.chtti.springboot.demo.Demo7JPADocker.beans.Beverage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        loadSomeData();
        loadDAtaByPage();
        loadDataByLike();
        loadDataByContaining();
    }

    private void loadDataByContaining() {
        LOGGER.info("find detail with milk");
        repository.findByDetailContaining("miik")
                .forEach(b -> LOGGER.info("with milk:{}", b));
        repository.findByDetailContaining("hot").forEach(
                b -> LOGGER.info("with hot:{}",b));

    }

    private void loadDataByLike() {
        LOGGER.info("find hot");
        repository.findByTitleLike("hot%")
                .forEach(beverage -> LOGGER.info("'hot prefix:'{}", beverage));
        repository.findByTitleLike("%latte")
                .forEach(beverage -> LOGGER.info("'end with latte:{}'", beverage));
    }

    private void loadDAtaByPage(){
        LOGGER.info("load data by page");
        PageRequest  pr1 = PageRequest.of(0,4);
        repository.findAll(pr1).forEach(beverage -> {
            LOGGER.info("first pagesL{}",pr1.getPageNumber(),beverage);
        });
        Pageable pageable = pr1.next();
        repository.findAll(pageable).forEach(beverage -> {
            LOGGER.info("#{} page:{}", pageable.getPageNumber(), beverage);
        });
        ;
    }

    private void loadSomeData(){
        LOGGER.info("find all americano only");
        repository.findMatchByTitle("americano").forEach(beverage -> LOGGER.info(
                "americano only ==>{}",beverage));
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
        repository.save(new Beverage("americano","ice black coffee witn no milk"));
        repository.save(new Beverage("americano","hot black coffee witn no milk"));
        repository.save(new Beverage("ice latte","espresso with 60% milk"));
        repository.save(new Beverage("hot latte","espresso with 60% milk"));
        repository.save(new Beverage("ice Assam black tea","nomral black twa"));
        repository.save(new Beverage("hot Assam black tea","nomral black twa"));
        repository.save(new Beverage("ice milk tea","ice black tea with milke"));
        repository.save(new Beverage("hot milk tea","ice black tea with milke"));
    }
}
