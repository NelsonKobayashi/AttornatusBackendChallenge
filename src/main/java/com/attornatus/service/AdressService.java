package com.attornatus.service;

import com.attornatus.entities.Adress;
import com.attornatus.repository.IAdressRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdressService {

    @Autowired
    private IAdressRepository iAdressRepository;

    final static Logger log = Logger.getLogger(AdressService.class);

    public Adress save(Adress adress){
        log.debug("Registering a new endereço.");
        iAdressRepository.save(adress);
        return adress;
    }

    public Optional<Adress> search(Integer id){
        log.debug("Searching adress by Id: " + id);
        return iAdressRepository.findById(id);
    }

    public List<Adress> getAll() {
        log.debug("Searching all addresses");
        return iAdressRepository.findAll();
    }

    public void delete(Integer id) {
        log.debug("Deleting adress with ID: " + id);
        iAdressRepository.deleteById(id);
    }

    public Adress update(Adress adress) {
        log.debug("Updating adress.");
        return iAdressRepository.save(adress);
    }

}
