package com.agileea.partymngrms.Repository;

import java.util.List;
import java.util.Optional;

import com.agileea.partymngrms.Model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepo extends JpaRepository<Party, Long> {

    void deleteById(Long id);

    Optional<Party> findPartyById(Long id);
    
    Optional<List<Party>> findPartyByFirstname(String firstname);

    Optional<List<Party>> findPartyBySurname(String surname);

    Optional<List<Party>> findPartyByOrgname(String orgname);
}
