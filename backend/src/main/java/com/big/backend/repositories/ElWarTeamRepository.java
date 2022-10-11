package com.big.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.big.backend.models.ElWarTeam;

import java.util.List;

public interface ElWarTeamRepository extends JpaRepository<ElWarTeam, Long> {
    void deleteEwteamById(Long id);

    ElWarTeam findEwteamById(Long id);

    List<ElWarTeam> findAllByOrderById();


}
