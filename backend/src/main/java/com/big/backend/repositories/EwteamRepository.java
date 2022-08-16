package com.big.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.big.backend.models.Ewteam;

public interface EwteamRepository extends JpaRepository<Ewteam, Long> {
    void deleteEwteamById(Long id);

    Ewteam findEwteamById(Long id);
}
