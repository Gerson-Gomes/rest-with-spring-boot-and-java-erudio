package br.com.erudio.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exeptions.ResourceNotFound;
import br.com.erudio.repositories.PersonRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonServices  {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());



    @Autowired
    PersonRepositories repository;

    public List<PersonVO> findAll() {
        logger.info("Finding all people");

        return repository.findAll();
    }

    public PersonVO findById(Long id) {

        logger.info("Finding one Person!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
    }

    public PersonVO createPerson(PersonVO person) {
        logger.info("creating Person");
        return repository.save(person);
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("Updating Person");

        PersonVO entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        return repository.save(person);
    }

    public void deletePerson(Long id) {
        logger.info("Deleting Person");
        PersonVO entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
        repository.delete(entity);
    }


}
