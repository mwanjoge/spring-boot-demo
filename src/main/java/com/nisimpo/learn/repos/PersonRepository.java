package com.nisimpo.learn.repos;

import com.nisimpo.learn.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>  {

}
