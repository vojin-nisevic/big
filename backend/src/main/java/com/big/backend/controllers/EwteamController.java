package com.big.backend.controllers;

import com.big.backend.modelsDto.ElWarTeamsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.big.backend.models.ElWarTeam;
import com.big.backend.services.ElWarTeamService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/ewteam")
public class EwteamController {
    private final ElWarTeamService elWarTeamService;

    @Autowired
    public EwteamController(ElWarTeamService elWarTeamService) {
        this.elWarTeamService = elWarTeamService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<ElWarTeamsDto> elWarTeams = elWarTeamService.getAllWithPlayers();
//        if (ewteams != null) {
            return new ResponseEntity<>(elWarTeams, HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(new EwTeamNotFoundException("No teams"), HttpStatus.NOT_FOUND); //
//        }
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<ElWarTeam> getById(@PathVariable("id") Long id){
        try {
            var team = elWarTeamService.findTeamById(id);
            return new ResponseEntity<>(team, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(path = "/edit") // TODO: edit with id
    public ResponseEntity<ElWarTeam> updateEwTeam(@RequestBody ElWarTeam elWarTeam){
        var team = elWarTeamService.updateEwteam(elWarTeam);
        return  new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ElWarTeam> add(@RequestBody ElWarTeam elWarTeam){
        var team = elWarTeamService.addEwteam(elWarTeam);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteEwTeamById(@PathVariable("id") Long id){
        elWarTeamService.deleteEwteam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
