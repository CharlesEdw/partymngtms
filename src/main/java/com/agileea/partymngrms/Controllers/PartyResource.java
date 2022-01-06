package com.agileea.partymngrms.Controllers;

import java.util.List;

import com.agileea.partymngrms.Model.*;
import com.agileea.partymngrms.Services.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/party")
public class PartyResource {
    private final PartyService partyService;

    public PartyResource(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Party>> getAllParties() {
        List<Party> parties =partyService.findAllParties();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable("id") Long id) {
        Party party;
        try {
            party = partyService.findPartyById(id);
        } catch (Throwable e) {
            e.printStackTrace();
            party = null;
            return new ResponseEntity<>(party, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(party, HttpStatus.OK);
    }

    @GetMapping("/firstname")
    public ResponseEntity<List<Party>> getPartyByFirstname(@RequestParam("firstname") String firstname) {
        List<Party> parties;
        try {
            parties = (List<Party>) partyService.findPartyByFirstname(firstname);
        } catch (Throwable e) {
            e.printStackTrace();
            parties = null;
            return new ResponseEntity<>(parties, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }
    @GetMapping("/surname")
    public ResponseEntity<List<Party>> getPartyBySurname(@RequestParam("surname") String surname) {
        List<Party> parties;
        try {
            parties = (List<Party>) partyService.findPartyBySurname(surname);
        } catch (Throwable e) {
            e.printStackTrace();
            parties = null;
            return new ResponseEntity<>(parties, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }
    @GetMapping("/orgname")
    public ResponseEntity<List<Party>> getPartyByOrgname(@RequestParam("orgname") String orgname) {
        List<Party> parties;
        try {
            parties = (List<Party>) partyService.findPartyByOrgname(orgname);
        } catch (Throwable e) {
            e.printStackTrace();
            parties = null;
        }
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Party> addParty(@RequestBody Party party) {
        Party newparty = partyService.addParty(party);
        return new ResponseEntity<>(newparty, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Party> updateParty(@RequestBody Party party) {
        Party updateparty = partyService.updateParty(party);
        return new ResponseEntity<>(updateparty, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParty(@PathVariable("id") Long id) {
        partyService.deleteParty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
