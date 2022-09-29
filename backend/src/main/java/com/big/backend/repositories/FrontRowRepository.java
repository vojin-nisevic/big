package com.big.backend.repositories;

import com.big.backend.models.FrontRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrontRowRepository extends JpaRepository<FrontRow, Long> {

    FrontRow findFrontRowById(Long id);

}
