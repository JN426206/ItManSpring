package ItMan.api.services;

import ItMan.api.entities.Firma;
import ItMan.api.repositories.FirmaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmaServiceImpl implements FirmaService {
    //private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private FirmaRepository firmaRepository;

    @Override
    public Iterable<Firma> listAllFirmy(){
        //logger.info("listaAllFirmy");
        return firmaRepository.findAll();
    }

    @Override
    public Firma getFirmaById(Integer id){
        return firmaRepository.findOne(id);
    }

    @Override
    public Firma saveFirma(Firma firma){
        return firmaRepository.save(firma);
    }

    @Override
    public void removeFirma(Integer id) { firmaRepository.delete(id); }

    @Override
    public Boolean checkIfExist(Integer id){
        if (firmaRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
