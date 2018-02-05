package ItMan.api.controllers;

import ItMan.api.entities.Urzadzenie;
import ItMan.api.services.UrzadzenieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UrzadzenieController {
    private final Logger logger = Logger.getLogger("Controller");

    @Autowired
    private UrzadzenieService urzadzenieService;

    @RequestMapping(value = "/urzadzenia", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Urzadzenie> list(Model model) {
        return urzadzenieService.listAllUrzadzenia();
    }

    @RequestMapping(value = "/urzadzenia", method = RequestMethod.POST)
    public ResponseEntity<Urzadzenie> create(@RequestBody @Valid @NotNull Urzadzenie urzadzenie) {
        urzadzenieService.saveUrzadzenie(urzadzenie);
        return ResponseEntity.ok().body(urzadzenie);
    }

    @RequestMapping(value = "/urzadzenia/{idFirmy}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Urzadzenie> getByIdFirmy(@PathVariable("idFirmy") Integer idFirmy){
        logger.info(idFirmy.toString());
        return urzadzenieService.getUrzadzeniaByIdFirmy(idFirmy);
    }

    @RequestMapping(value = "/urzadzenia/urzadzenie/{idUrzadzenia}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Urzadzenie getByIdUrzadzenia(@PathVariable("idUrzadzenia") Integer idUrzadzenia){
        logger.info(idUrzadzenia.toString());
        return urzadzenieService.getUrzadzenieById(idUrzadzenia);
    }
}