package br.com.erudio.services;

import br.com.erudio.exeptions.ResourceNotFound;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepositories repository;

    public List<Person> findAll() {
        logger.info("Finding all people");

        return repository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding one Person!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
    }

    public Person createPerson(Person person) {
        logger.info("creating Person");
        return repository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating Person");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        return repository.save(person);
    }

    public void deletePerson(Long id) {
        logger.info("Deleting Person");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
        repository.delete(entity);
    }


}
