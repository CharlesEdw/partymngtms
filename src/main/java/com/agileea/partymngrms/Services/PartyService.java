package com.agileea.partymngrms.Services;

import java.util.List;

import com.agileea.partymngrms.Model.*;
import com.agileea.partymngrms.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
    private final PartyRepo partyRepo;

    @Autowired
    public PartyService(PartyRepo partyRepo) {
        this.partyRepo = partyRepo;
    }
    
    public Party addParty(Party party) {
        return partyRepo.save(party);
    }

    public List<Party> findAllParties() {
        return partyRepo.findAll();
    }

    public Party updateParty(Party party) {
        return partyRepo.save(party);
    }

    public Party findPartyById(Long id) throws Throwable{
        return partyRepo.findPartyById(id)
        .orElseThrow(() -> new com.agileea.partymngrms.Exceptions.UserNotFoundException("Party by Id " + id + " was not found"));

    }
    
    public List<Party> findPartyByFirstname(String firstName) throws Throwable{
        return partyRepo.findPartyByFirstname(firstName)
        .orElseThrow(() -> new com.agileea.partymngrms.Exceptions.UserNotFoundException("Party by Firstname "
         + firstName + " was not found"));

    }

    public void deleteParty(Long id) {
        partyRepo.deleteById(id);
    }
}
