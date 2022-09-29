package com.big.backend.controllers;


import com.big.backend.models.MeritRank;
import com.big.backend.services.MeritRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/merit_rank")
public class MeritRankController {

    private MeritRankService _meritRankService;

    @Autowired
    public MeritRankController(MeritRankService meritRankService) {
        _meritRankService = meritRankService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<MeritRank> meritRanks = _meritRankService.getAll();
        if (meritRanks != null) {
            return new ResponseEntity<>(meritRanks, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new Error("No Merit Ranks in database!"), HttpStatus.NOT_FOUND);
        }
    }


}
