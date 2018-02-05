package ItMan.api.controllers;

import ItMan.api.entities.Adres;
import ItMan.api.services.AdresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class AdresController {
    private final Logger logger = Logger.getLogger("Controller");

    @Autowired
    private AdresService adresService;


    @RequestMapping(value = "/adres", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Adres> list(Model model) {
        return adresService.listAllAdres();
    }

    @RequestMapping(value = "/adres", method = RequestMethod.POST)
    public ResponseEntity<Adres> create(@RequestBody @Valid @NotNull Adres adres) {
        adresService.saveAdres(adres);
        return ResponseEntity.ok().body(adres);
    }
}
