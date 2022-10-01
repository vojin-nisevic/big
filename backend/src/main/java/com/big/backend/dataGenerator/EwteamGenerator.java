package com.big.backend.dataGenerator;

import com.big.backend.models.Ewteam;
import com.big.backend.repositories.EwteamRepository;
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

    private final EwteamRepository _ewteamRepository;

    private final ArrayList<Ewteam> ewteams;

    private final String[] namePool;

    public EwteamGenerator(EwteamRepository ewteamRepository) {
        _ewteamRepository = ewteamRepository;
        ewteams = new ArrayList<>();
        namePool = new String[]{
                "Red", "Green", "Blue"
        };
    }

    @PostConstruct
    public void generateData() {
        if (_ewteamRepository.findAll().size() > 0) {
            LOGGER.info("Elite wars teams created, skipping creation.");
        } else {
            LOGGER.info("Creating Elite wars teams.");
            Ewteam tmp;
            for (int i = 0; i < namePool.length; i++) {
                tmp = _ewteamRepository.save(Ewteam.EwteamBuilder.anEwteamBuilder()
                        .withName(namePool[i])
                        .build()
                );
                LOGGER.info("Elite wars team '{} {}' created.", tmp.getId(), tmp.getName());
                ewteams.add(tmp);
            }
        }
    }
}
