package com.big.backend.controllers;

import com.big.backend.exception.RequestCustomException;
import com.big.backend.models.PlayerIds;
import com.big.backend.modelsDto.PlayerDto;
import com.big.backend.modelsDto.PlayerElWarDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.big.backend.models.Player;
import com.big.backend.services.PlayerService;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping(path = "/players")
public class PlayerController {

    private final PlayerService playerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //returns list of dto for player
    @GetMapping()
    public ResponseEntity<List<PlayerDto>> getAll() {
        List<PlayerDto> list = playerService.getAll().stream().map(Player::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Player> add(@RequestBody Player player) {
        Player newPlayer = playerService.add(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Player> get(@PathVariable("id") Long id) {
        Player player = playerService.getById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        playerService.delete(id);
    }

    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<Player> edit(@RequestBody Player player) {
        Player player1 = playerService.edit(player);
        return new ResponseEntity<>(player1, HttpStatus.OK);
    }



    /**
     * changing team of players
     * @param players array of players
     * @param id id of new team
     */
    @PutMapping(path = "/change/teams/{id}")
    public boolean updateTeams(@RequestBody PlayerIds players, @PathVariable("id") Long id) {
        System.out.println("KKKKKK");
        Long[] list = players.getPlayerIdList();
        System.out.println("Players: " + Arrays.toString(list));
        for (Long p: list
             ) {
            LOGGER.info("Array: " + p);
        }
        playerService.updateElWarTeam(id, list);
        return true;
    }



    //returns the list of ElWarDto players
    @GetMapping(path = "/byteam/{id}")
    public ResponseEntity<List<PlayerElWarDto>> findPlayersByTeam(@PathVariable("id") Long id) {
        System.out.println("TEST");
        List<PlayerElWarDto> list = playerService.findPlayerByElWarTeam(id)
                .stream().map(Player::toElWarDto).collect(Collectors.toList());
        if (list.size() == 0){
            throw new RequestCustomException("No players belonging to this team", 404);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
