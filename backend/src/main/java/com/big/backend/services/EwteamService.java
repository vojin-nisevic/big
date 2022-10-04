package com.big.backend.services;

import com.big.backend.exception.RequestCustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.big.backend.models.Ewteam;
import com.big.backend.repositories.EwteamRepository;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class EwteamService {
    private final EwteamRepository ewteamRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
        if (ewteamRepository.findEwteamById(ewteam.getId()) == null){
            throw new RequestCustomException("There is no Elite War team with name " + ewteam.getName(), 404);
        }
        try {
            return ewteamRepository.save(ewteam);
        }
        catch (Exception e) {
            LOGGER.info(e.getCause().getMessage());
            throw e;
        }
    }

    public void deleteEwteam(Long id){
        var team = ewteamRepository.findEwteamById(id);
        if (team != null){
            ewteamRepository.delete(team);
        }
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
