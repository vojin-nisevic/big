package com.big.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.big.backend.models.Player;
import com.big.backend.models.Ewteam;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerById(Long id);

    List<Player> findPlayerByewTeam(Ewteam ewteam);
}
