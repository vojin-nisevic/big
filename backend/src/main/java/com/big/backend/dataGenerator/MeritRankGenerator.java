package com.big.backend.dataGenerator;

import com.big.backend.models.MeritRank;
import com.big.backend.repositories.MeritRankRepository;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;


@Profile("initialize data")
@Component
public class MeritRankGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final MeritRankRepository _meritRankRepository;
    private final ArrayList<MeritRank> meritRanks;
    private final String[] namePool;


    public MeritRankGenerator(MeritRankRepository meritRankRepository) {
        _meritRankRepository = meritRankRepository;
        this.meritRanks = new ArrayList<>();
        namePool = new String[]{
                "Private", "Sergeant", "Sergeant Major", "Lieutenant Knight", "Centurion", "Striker Battalion",
                "Legion Officer", "Legion Commander", "High Commander", "Royal Commander", "Captain", "General",
                "Commander-in-Chief", "Overseer", "Grand Marshal", "Star Marshal", "Legendary Marshal", "War Lord"
        };


    }

    @PostConstruct
    public void generateData() {
        if (_meritRankRepository.findAll().size() > 0) {
            LOGGER.info("Merit ranks created, skipping creation!");
        }
        else {
            LOGGER.info("Creating merit ranks.");
            MeritRank tmp;
            for (int i = 0; i < namePool.length; i++){
                tmp = _meritRankRepository.save(MeritRank.MeritRankBuilder.anMeritRankBuilder()
                        .withName(namePool[i])
                        .build()
                );
                LOGGER.info("Merit rank '{} {}' created.", tmp.getId(), tmp.getName());
                this.meritRanks.add(tmp);
            }
        }
    }
}
