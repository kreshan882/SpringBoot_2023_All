package com.kre.mongo.controller;


import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kre.mongo.collection.Person;
import com.kre.mongo.service.PersonService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public String save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getPersonStartWith(@RequestParam("name") String name) {
        return personService.getPersonStartWith(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        personService.delete(id);
    }

    //using JPQL
    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam Integer minAge,
                                       @RequestParam Integer maxAge) {
        return personService.getByPersonAge(minAge,maxAge);
    }

    //pageable data
    @GetMapping("/searchPagable")
    public Page<Person> searchPersonPagaple(
            @RequestParam(required = false) String name,@RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,@RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "3") Integer size) {
    	
		        Pageable pageable = PageRequest.of(page,size);
		        return personService.search(name,minAge,maxAge,city,pageable);
    }

    
    @GetMapping("/oldestPerson")
    public List<Document> getOldestPerson() {
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/populationByCity")
    public List<Document> getPopulationByCity() {
        return personService.getPopulationByCity();
    }
}