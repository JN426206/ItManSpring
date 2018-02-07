package ItMan.api.services;

import ItMan.api.entities.Urzadzenie;
import ItMan.api.repositories.UrzadzenieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrzadzenieServiceImpl implements UrzadzenieService {

    @Autowired
    private UrzadzenieRepository urzadzenieRepository;

    @Override
    public Iterable<Urzadzenie> listAllUrzadzenia() {
        return this.urzadzenieRepository.findAll();
    }

    @Override
    public Iterable<Urzadzenie> getUrzadzeniaByIdFirmy(Integer idFirmy) {
        return this.urzadzenieRepository.findUrzadzeniesByFirma_IdFirmy(idFirmy);
    }

    @Override
    public void removeUrzadzenie(Integer id) { urzadzenieRepository.delete(id); }

    @Override
    public Urzadzenie getUrzadzenieById(Integer id) {
        return this.urzadzenieRepository.findOne(id);
    }

    @Override
    public Urzadzenie saveUrzadzenie(Urzadzenie urzadzenie) {
        return this.urzadzenieRepository.save(urzadzenie);
    }

    @Override
    public boolean checkIfExist(Integer id) {
        if (urzadzenieRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }
}
