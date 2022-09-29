package com.big.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.big.backend.exceptions.EwTeamNotFoundException;
import com.big.backend.models.Ewteam;
import com.big.backend.services.EwteamService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/ewteam")
public class EwteamController {
    private final EwteamService ewteamService;

    @Autowired
    public EwteamController(EwteamService ewteamService) {
        this.ewteamService = ewteamService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Ewteam> ewteams = ewteamService.GetAll();
        if (ewteams != null) {
            return new ResponseEntity<>(ewteams, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new EwTeamNotFoundException("No teams"), HttpStatus.NOT_FOUND); //
        }
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Ewteam> getById(@PathVariable("id") Long id){
        try {
            var team = ewteamService.findTeamById(id);
            return new ResponseEntity<>(team, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping(path = "/edit") // TODO: edit with id
    public ResponseEntity<Ewteam> updateEwTeam(@RequestBody Ewteam ewteam){
        var team = ewteamService.updateEwteam(ewteam);
        return  new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Ewteam> add(@RequestBody Ewteam ewteam){
        var team = ewteamService.addEwteam(ewteam);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteEwTeamById(@PathVariable("id") Long id){
        ewteamService.deleteEwteam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
