package com.big.backend.dataGenerator;

import com.big.backend.models.BackRow;
import com.big.backend.repositories.BackRowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;

@Profile("initialize data")
@Component
public class BackRowGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final BackRowRepository _backRowRepository;

    private final ArrayList<BackRow> backRows;

    private final String[] namePool;

    public BackRowGenerator(BackRowRepository backRowRepository) {
        _backRowRepository = backRowRepository;
        backRows = new ArrayList<>();
        namePool = new String[]{
                "Archers", "Mages"
        };
    }

    @PostConstruct
    public void generateData() {
        if (_backRowRepository.findAll().size() > 0) {
            LOGGER.info("Back rows created, skipping creation.");
        } else {
            LOGGER.info("Creating back rows.");
            BackRow tmp;
            for (int i = 0; i < namePool.length; i++) {
                tmp = _backRowRepository.save(BackRow.BackRowBuilder.anBackRowBuilder()
                        .withName(namePool[i])
                        .build()
                );
                LOGGER.info("Back row '{} {}' created.", tmp.getId(), tmp.getName());
                backRows.add(tmp);
            }
        }
    }
}
