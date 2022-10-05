package com.big.backend.controllers;

import com.big.backend.modelsDto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.big.backend.models.Player;
import com.big.backend.services.PlayerService;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping(path = "/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //returns list of dto for player
    @GetMapping()
    public ResponseEntity<List<PlayerDto>> getAll(){
        List<PlayerDto> list = playerService.GetAll().stream().map(player -> player.toDto()).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Player> add(@RequestBody Player player){
        Player newPlayer = playerService.Add(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping(path = "/byteam/{id}")
    public ResponseEntity<List<Player>> findPlayersByTeam(@PathVariable("id") Long id){
        List<Player> list = playerService.FindPlayerByEwteam(id);
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
}
