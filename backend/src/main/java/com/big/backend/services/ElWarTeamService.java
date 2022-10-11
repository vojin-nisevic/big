package com.big.backend.services;

import com.big.backend.exception.RequestCustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.big.backend.models.ElWarTeam;
import com.big.backend.repositories.ElWarTeamRepository;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class ElWarTeamService {
    private final ElWarTeamRepository elWarTeamRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    public ElWarTeamService(ElWarTeamRepository elWarTeamRepository) {
        this.elWarTeamRepository = elWarTeamRepository;
    }

    public List<ElWarTeam> getAll(){
        return elWarTeamRepository.findAllByOrderById();
    }

    public ElWarTeam addEwteam(ElWarTeam elWarTeam) {
        return elWarTeamRepository.save(elWarTeam);
    }

    public ElWarTeam updateEwteam(ElWarTeam elWarTeam){
        if (elWarTeamRepository.findEwteamById(elWarTeam.getId()) == null){
            throw new RequestCustomException("There is no Elite War team with name " + elWarTeam.getName(), 404);
        }
        try {
            return elWarTeamRepository.save(elWarTeam);
        }
        catch (Exception e) {
            LOGGER.info(e.getCause().getMessage());
            throw e;
        }
    }

    public void deleteEwteam(Long id){
        ElWarTeam team = elWarTeamRepository.findEwteamById(id);
        if (team != null){
            elWarTeamRepository.delete(team);
        }
        else {
            throw new RequestCustomException("Elite war team you wanted to delete doesn't exist.", 404);
        }
    }

    public ElWarTeam findTeamById(Long id){
        ElWarTeam team = elWarTeamRepository.findEwteamById(id);
        if (team != null){
            return team;
        }
        else {
            throw new RequestCustomException("Elite war team you requested doesn't exist.", 404);
        }
    }

    //add
}
