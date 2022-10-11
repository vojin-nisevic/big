package com.big.backend.services;

import com.big.backend.exception.RequestCustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.big.backend.models.ElWarTeam;
import com.big.backend.models.Player;
import com.big.backend.repositories.ElWarTeamRepository;
import com.big.backend.repositories.PlayerRepository;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class PlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final PlayerRepository playerRepository;
    private final ElWarTeamRepository elWarTeamRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, ElWarTeamRepository elWarTeamRepository) {
        this.playerRepository = playerRepository;
        this.elWarTeamRepository = elWarTeamRepository;
    }

    public List<Player> getAll() {
        List<Player> list = playerRepository.findAll();
        if (list.size() == 0) {
            throw new RequestCustomException("There are no players in the database", 404);
        }
        return list;
    }

    public Player getById(Long id) {
        Player player = playerRepository.findPlayerById(id);
        if (player == null) {
            throw new RequestCustomException("There is no such player in the database!", 404);
        }
        return player;
    }

    //check for original and current names and throws exception if some of them already exists
    public Player add(Player player) {
        if (playerRepository.findPlayerByOriginalNameOrCurrentName(player.getOriginalName(), player.getCurrentName()) != null) {
            throw new RequestCustomException("Player with names: " + player.getOriginalName() + " : "
                    + player.getCurrentName() + " already exists!", 209);
        }
        return playerRepository.save(player);
    }

    //check for id if exists
    public Player edit(Player player) {
        if (playerRepository.findPlayerById(player.getId()) == null) {
            throw new RequestCustomException("Player with that original or current name already exists", 209);
        }
        return playerRepository.save(player);
    }

    //check for player
    public void delete(Long id) {
        Player player = playerRepository.findPlayerById(id);
        if (player == null) {
            throw new RequestCustomException("Player doesn't exists!", 404);
        }
        playerRepository.delete(player);
    }

    public List<Player> findPlayerByElWarTeam(Long team) {
        ElWarTeam elWarTeam = elWarTeamRepository.findEwteamById(team);
        List<Player> players = playerRepository.findPlayerByewTeam(elWarTeam);
        if (players == null || players.size() == 0) {
            throw new RequestCustomException("Team: " + elWarTeam.getName() + " has no players!");
        }
        return players;
    }

    /**
     * change players elite war team. parameters are new elite war team and array of players id
     * @param team Long: team id
     * @param players Long: array of players id's
     */
    public void updateElWarTeam(Long team, Long[] players) {
//        for (Long p: players
//             ) {
//            LOGGER.info("Array: " + p);
//        }
        if (team == null || players == null) {
            throw new RequestCustomException("Bad request", 400);
        }
        for (Long p: players
             ) {
            playerRepository.updateElWarTeam(p,team);
        }
    }


}
