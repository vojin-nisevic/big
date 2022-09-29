package com.big.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.big.backend.models.Ewteam;
import com.big.backend.repositories.EwteamRepository;

import java.util.List;

@Service
public class EwteamService {
    private final EwteamRepository ewteamRepository;

    @Autowired
    public EwteamService(EwteamRepository ewteamRepository) {
        this.ewteamRepository = ewteamRepository;
    }

    public List<Ewteam> GetAll(){
        return ewteamRepository.findAllByOrderById();
    }

    public Ewteam addEwteam(Ewteam ewteam) {
        return ewteamRepository.save(ewteam);
    }

    public Ewteam updateEwteam(Ewteam ewteam){
        return ewteamRepository.save(ewteam);
    }

    public void deleteEwteam(Long id){
        var team = ewteamRepository.findEwteamById(id);
        if (team != null){
            ewteamRepository.delete(team);
        }
//        ewteamRepository.deleteEwteamById(id);
    }

    public Ewteam findTeamById(Long id) throws Exception {
        var team = ewteamRepository.findEwteamById(id);
        if (team != null){
            return team;
        }
        else {
            throw new Exception("Tralala");
        }
    }
}
