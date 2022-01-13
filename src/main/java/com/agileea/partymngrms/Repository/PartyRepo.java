package com.agileea.partymngrms.Repository;

import java.util.List;
import java.util.Optional;

import com.agileea.partymngrms.Model.Party;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface PartyRepo extends PagingAndSortingRepository<Party, Long> {

    void deleteById(Long id);

    Party findPartyById(Long id); 

    Optional<List<Party>> findPartyByFirstname(String firstname);

    Optional<List<Party>> findPartyBySurname(String surname);

    Optional<List<Party>> findPartyByOrgname(String orgname);
}
