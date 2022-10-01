package com.big.backend.dataGenerator;

import com.big.backend.models.FrontRow;
import com.big.backend.repositories.FrontRowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

@Profile("initialize data")
@Component
public class FrontRowGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final FrontRowRepository _frontRowRepository;

    private final ArrayList<FrontRow> frontRows;

    private final String[] namePool;

    public FrontRowGenerator(FrontRowRepository frontRowRepository) {
        _frontRowRepository = frontRowRepository;

        frontRows = new ArrayList<>();
        namePool = new String[]{
                "Infantry", "Cavalry"
        };
    }

    @PostConstruct
    public void generateData() {
        if (_frontRowRepository.findAll().size() > 0) {
            LOGGER.info("Front row created, skipping creation!");
        } else {
            LOGGER.info("Creating front rows.");
            FrontRow tmp;
            for (int i = 0; i < namePool.length; i++) {
                tmp = _frontRowRepository.save(FrontRow.FrontRowBuilder.anFrontRowBuilder()
                        .withName(namePool[i])
                        .build()
                );
                LOGGER.info("Front row '{} {}' created", tmp.getId(), tmp.getName());
                this.frontRows.add(tmp);
            }
        }
    }
}
