package ItMan.api.controllers;

import ItMan.api.entities.Firma;
import ItMan.api.services.FirmaService;
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
public class FirmaController {
    private final Logger logger = Logger.getLogger("Controller");

    @Autowired
    private FirmaService firmaService;


    @RequestMapping(value = "/firmy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Firma> list(Model model) {
        return firmaService.listAllFirmy();
    }

    @RequestMapping(value = "/firmy", method = RequestMethod.POST)
    public ResponseEntity<Firma> create(@RequestBody @Valid @NotNull Firma firma) {
        firmaService.saveFirma(firma);
        return ResponseEntity.ok().body(firma);
    }

    @RequestMapping(value = "/firmy/{idFirmy}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Firma getByPublicId(@PathVariable("idFirmy") Integer idFirmy){
        logger.info(idFirmy.toString());
        return firmaService.getFirmaById(idFirmy);
    }

    @RequestMapping(value = "/firmy/{idFirmy}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeByIdFirmy(@PathVariable("idFirmy") Integer idFirmy){
        logger.info(idFirmy.toString());
        firmaService.removeFirma(idFirmy);
    }

    @RequestMapping(value = "/firmy", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Firma> update(@RequestBody @Valid @NotNull Firma firma) {
        firmaService.saveFirma(firma);
        return ResponseEntity.ok().body(firma);
    }
}
