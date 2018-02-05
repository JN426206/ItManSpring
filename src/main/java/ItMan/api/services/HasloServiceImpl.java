package ItMan.api.services;

import ItMan.api.entities.Haslo;
import ItMan.api.repositories.HasloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HasloServiceImpl implements  HasloService {

    @Autowired
    private HasloRepository hasloRepository;

    @Override
    public Iterable<Haslo> listAllHaslo() {
        return this.hasloRepository.findAll();
    }

    @Override
    public Haslo getHasloById(Integer id) {
        return this.hasloRepository.findOne(id);
    }

    @Override
    public Haslo saveHaslo(Haslo haslo) {
        return this.hasloRepository.save(haslo);
    }

    @Override
    public boolean checkIfExist(Integer id) {
        if (hasloRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
