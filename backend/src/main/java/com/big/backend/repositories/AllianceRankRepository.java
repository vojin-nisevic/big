package com.big.backend.repositories;

import com.big.backend.models.AllianceRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllianceRankRepository extends JpaRepository<AllianceRank, Integer> {

    void deleteAllianceRankById(Integer id);

    AllianceRank findAllianceRankById(Integer id);

    List<AllianceRank> findAllByOrderById();
}
