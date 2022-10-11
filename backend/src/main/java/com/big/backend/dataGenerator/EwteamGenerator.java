package com.big.backend.dataGenerator;

import com.big.backend.models.ElWarTeam;
import com.big.backend.repositories.ElWarTeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

@Profile("initialize data")
@Component
public class EwteamGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ElWarTeamRepository _elWarTeamRepository;

    private final ArrayList<ElWarTeam> elWarTeams;

    private final String[] namePool;

    public EwteamGenerator(ElWarTeamRepository elWarTeamRepository) {
        _elWarTeamRepository = elWarTeamRepository;
        elWarTeams = new ArrayList<>();
        namePool = new String[]{
                "Red", "Green", "Blue"
        };
    }

    @PostConstruct
    public void generateData() {
        if (_elWarTeamRepository.findAll().size() > 0) {
            LOGGER.info("Elite wars teams created, skipping creation.");
        } else {
            LOGGER.info("Creating Elite wars teams.");
            ElWarTeam tmp;
            for (int i = 0; i < namePool.length; i++) {
                tmp = _elWarTeamRepository.save(ElWarTeam.ElWarTeamBuilder.anEwteamBuilder()
                        .withName(namePool[i])
                        .build()
                );
                LOGGER.info("Elite wars team '{} {}' created.", tmp.getId(), tmp.getName());
                elWarTeams.add(tmp);
            }
        }
    }
}
