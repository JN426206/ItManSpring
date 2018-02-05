package ItMan.api.controllers;

import ItMan.api.entities.Haslo;
import ItMan.api.services.HasloService;
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

@RestController
@RequestMapping("/api")
public class HasloControler {

    @Autowired
    private HasloService hasloService;

    @RequestMapping(value = "/hasla", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Haslo> list(Model model) {
        return hasloService.listAllHaslo();
    }

    @RequestMapping(value = "/hasla", method = RequestMethod.POST)
    public ResponseEntity<Haslo> create(@RequestBody @Valid @NotNull Haslo firma) {
        hasloService.saveHaslo(firma);
        return ResponseEntity.ok().body(firma);
    }
}
