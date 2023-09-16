package com.kre.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.kre.mongo.collection.Person;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person,String> {   //JpaRepositery

    List<Person> findByFirstNameStartsWith(String name);

    // //JPA
    //List<Person> findByAgeBetween(Integer min, Integer max);

    //JPQL -- for JPA
    //@Query("select s from Student s where s.emailId=?1") 
    
    //JPQL -- for Mongo
    //@Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}",  fields = "{addresses:  0}") //skip the address
    @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}")
    List<Person> findPersonByAgeBetween(Integer min, Integer max);
}