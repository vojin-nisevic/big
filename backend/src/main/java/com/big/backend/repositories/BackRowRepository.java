package com.big.backend.repositories;

import com.big.backend.models.BackRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackRowRepository extends JpaRepository<BackRow, Long> {

    BackRow findBackRowById(Long id);
}
