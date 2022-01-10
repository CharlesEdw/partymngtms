package com.agileea.partymngrms.Services;

import java.util.List;
import java.util.Optional;

import com.agileea.partymngrms.Model.*;
import com.agileea.partymngrms.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Service
public class PartyService {
    private final PartyRepo partyRepo;

    @Autowired
    public PartyService(PartyRepo partyRepo) {
        this.partyRepo = partyRepo;
    }
    
    public Party addParty(Party party) {
        System.out.println("Party in Service: "+party);
        return partyRepo.saveAndFlush(party);
    }

    /* Original 
    public List<Party> findAllParties() {
        return partyRepo.findAll();
    }
    */

    public Page<Party> findAllParties(Optional<Integer> page, Optional<String> sortBy ) {
            return partyRepo.findAll(
                PageRequest.of(
                    page.orElse(0), 4,
                    Sort.by(Direction.ASC, sortBy.orElse("id"))
                )
            );
    }
    public Party updateParty(Party party) {
        return partyRepo.save(party);
    }

   
    public List<Party> findPartyByFirstname(String firstName) throws Throwable{
        return partyRepo.findPartyByFirstname(firstName)
        .orElseThrow(() -> new com.agileea.partymngrms.Exceptions.UserNotFoundException("Party by Firstname "
         + firstName + " was not found"));

    }
    public List<Party> findPartyBySurname(String surName) throws Throwable{
        return partyRepo.findPartyBySurname(surName)
        .orElseThrow(() -> new com.agileea.partymngrms.Exceptions.UserNotFoundException("Party by Surname "
         + surName + " was not found"));

    }
    public List<Party> findPartyByOrgname(String orgName) throws Throwable{
        return partyRepo.findPartyByOrgname(orgName)
        .orElseThrow(() -> new com.agileea.partymngrms.Exceptions.UserNotFoundException("Party by Orgname "
         + orgName + " was not found"));

    }

    public Party findPartyById(Long id) {
        return partyRepo.getById(id);
    }

    public void deleteParty(Long id) {
        partyRepo.deleteById(id);
    }
}
