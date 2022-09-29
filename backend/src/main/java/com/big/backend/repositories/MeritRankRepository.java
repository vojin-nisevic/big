package com.big.backend.repositories;

import com.big.backend.models.MeritRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeritRankRepository extends JpaRepository<MeritRank, Long> {

    void deleteMeritRankById(Long id);

    MeritRank findMeritRankById(Long id);

    List<MeritRank> findAllByOrderById();
}
