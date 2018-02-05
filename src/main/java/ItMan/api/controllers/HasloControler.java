package ItMan.api.controllers;

import ItMan.api.entities.Haslo;
import ItMan.api.services.HasloService;
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
public class HasloControler {
    private final Logger logger = Logger.getLogger("Controller");

    @Autowired
    private HasloService hasloService;

    @RequestMapping(value = "/hasla", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Haslo> list(Model model) {
        return hasloService.listAllHaslo();
    }

    @RequestMapping(value = "/hasla", method = RequestMethod.POST)
    public ResponseEntity<Haslo> create(@RequestBody @Valid @NotNull Haslo haslo) {
        hasloService.saveHaslo(haslo);
        return ResponseEntity.ok().body(haslo);
    }

    @RequestMapping(value = "/hasla/{idFirmy}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Haslo> getByIdFirmy(@PathVariable("idFirmy") Integer idFirmy){
        logger.info(idFirmy.toString());
        return hasloService.getHasloByIdFirmy(idFirmy);
    }

    @RequestMapping(value = "/hasla/haslo/{idHasla}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Haslo getByIdHasla(@PathVariable("idHasla") Integer idHasla){
        logger.info(idHasla.toString());
        return hasloService.getHasloById(idHasla);
    }
}
