package com.big.backend.dataGenerator;

import com.big.backend.models.AllianceRank;
import com.big.backend.models.MeritRank;
import com.big.backend.repositories.AllianceRankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

@Profile("initialize data")
@Component
public class AllianceRankGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final AllianceRankRepository _allianceRankRepository;

    private final ArrayList<AllianceRank> allianceRanks;

    private final String[] namePool;
    private final String[] descriptionPool;

    public AllianceRankGenerator(AllianceRankRepository allianceRankRepository) {
        _allianceRankRepository = allianceRankRepository;
        allianceRanks = new ArrayList<>();
        namePool = new String[]{
                "R5", "R4", "R3", "R2", "R1"
        };
        descriptionPool = new String[]{
                "Leader", "Deputy", "Officer", "Elite", "Member"
        };
    }

    @PostConstruct
    public void generateData(){
        if (_allianceRankRepository.findAllByOrderById().size() > 0){
            LOGGER.info("Alliance ranks created, skipping creation!");
        }
        else {
            LOGGER.info("Creating alliance ranks.");
            AllianceRank tmp;
            for (int i = 0; i < namePool.length; i++){
                tmp = _allianceRankRepository.save(AllianceRank.AllianceRankBuilder.anAllianceRankBuilder()
                        .withName(namePool[i])
                        .withDescription(descriptionPool[i])
                        .build()
                );
                LOGGER.info("Alliance rank '{} {} {}' created.", tmp.getId(), tmp.getName(), tmp.getDescription());
                this.allianceRanks.add(tmp);
            }
        }
    }


}
