package com.big.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.big.backend.models.Ewteam;
import com.big.backend.models.Player;
import com.big.backend.repositories.EwteamRepository;
import com.big.backend.repositories.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final EwteamRepository ewteamRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, EwteamRepository ewteamRepository) {
        this.playerRepository = playerRepository;
        this.ewteamRepository = ewteamRepository;
    }

    public List<Player> GetAll(){
        return playerRepository.findAll();
    }

    public Player GetById(Long id){
        return playerRepository.findPlayerById(id);
    }

    public Player Add(Player player){
        return  playerRepository.save(player);
    }

    public Player Edit(Player player){
        return playerRepository.save(player);
    }

    public void Delete(Player player){
        playerRepository.delete(player);
    }

    public List<Player> FindPlayerByEwteam(Long team){
//        var list = playerRepository.findAll();
//        List<Player> newList = new ArrayList<Player>();
//        for (var item: list
//             ) {
//            if (item.getEwTeam().getId() == team){
//                newList.add(item);
//            }
//        }
//        return newList;
        Ewteam ewteam = ewteamRepository.findEwteamById(team);
        return playerRepository.findPlayerByewTeam(ewteam);
    }

}
