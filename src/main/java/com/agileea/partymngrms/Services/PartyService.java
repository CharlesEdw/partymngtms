package com.agileea.partymngrms.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.agileea.partymngrms.Model.*;
import com.agileea.partymngrms.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

@Service
public class PartyService {
    private final PartyRepo partyRepo;

    @Autowired
    public PartyService(PartyRepo partyRepo) {
        this.partyRepo = partyRepo;
    }
    
    public Party addParty(Party party) {
        System.out.println("Party in Service: "+party);
        return partyRepo.save(party);
    }

    /* Original 
    public List<Party> findAllParties() {
        return partyRepo.findAll();
    }
    */

    public List<Party> findAllParties(  Optional<Integer> pageNo, 
                                        Optional<Integer> pageSize, 
                                        Optional<String> sortBy ) {

            Pageable paging = PageRequest.of(pageNo.orElse(0), pageSize.orElse(4), Sort.by(sortBy.orElse("id")));

            Page<Party> pagedResult = partyRepo.findAll(paging);
            if(pagedResult.hasContent()) {
                return pagedResult.getContent();
            } else {
                return new ArrayList<Party>();
            }
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

<<<<<<< HEAD
<<<<<<< HEAD
=======
    public List<Party> findPartyById(Long id) {
=======
    public List<Party> findListPartyById(Long id) {
>>>>>>> 66598d4a553e7192fc8a83581986f74bad5c3882
        List<Party> parties = new ArrayList<Party>();
        parties.add(partyRepo.findPartyById(id));
        return parties;
    }
>>>>>>> 661da3ef8c1f67291e22b448efc1676dc5039f4e

    public Party findPartyById(Long id) {
        return (Party) partyRepo.findPartyById(id);
    }

    public void deleteParty(Long id) {
        partyRepo.deleteById(id);
    }
}
