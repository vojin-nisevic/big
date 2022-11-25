package com.big.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.big.backend.models.Player;
import com.big.backend.models.ElWarTeam;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerById(Long id);

    Player findPlayerByOriginalNameOrCurrentName(String originalName, String currentName);
    List<Player> findPlayerByewTeam(ElWarTeam elWarTeam);

    @Query(value = "SELECT * FROM Player order by current_name offset :offset limit :limit" , nativeQuery = true)
    @Transactional
    List<Player> fetchPaginatedPlayers(int limit, int offset);

    @Query(value = "UPDATE player SET ewteam_id = :elWarTeam WHERE id = :playerId", nativeQuery = true)
    @Modifying
    @Transactional
    int updateElWarTeam(Long playerId, Long elWarTeam);

}
