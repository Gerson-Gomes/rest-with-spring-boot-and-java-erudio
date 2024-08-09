package br.com.erudio.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOv2;
import br.com.erudio.exeptions.ResourceNotFound;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;


@Service
public class PersonServices  {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepositories repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll() {
        logger.info("Finding all people");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        logger.info("Finding one Person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID!"));

        return DozerMapper.parseObject(entity,PersonVO.class);
    }

    public PersonVO createPerson(PersonVO person) {
        logger.info("creating Person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOv2 createV2(PersonVOv2 person) {
        logger.info("creating Person (V2)");
        var entity = mapper.convertVoToEntity(person);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("Updating Person");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void deletePerson(Long id) {
        logger.info("Deleting Person");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this ID"));
        repository.delete(entity);
    }


}
