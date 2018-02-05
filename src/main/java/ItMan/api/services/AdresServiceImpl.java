package ItMan.api.services;

import ItMan.api.entities.Adres;
import ItMan.api.repositories.AdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresServiceImpl implements AdresService {

    @Autowired
    private AdresRepository adresRepository;


    @Override
    public Iterable<Adres> listAllAdres() {
        return adresRepository.findAll();
    }

    @Override
    public Adres getAdresById(Integer id) {
        return adresRepository.findOne(id);
    }

    @Override
    public Adres saveAdres(Adres adres) {
        return adresRepository.save(adres);
    }

    @Override
    public boolean checkIfExist(Integer id) {
        if (adresRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
