package com.big.backend.services;

import com.big.backend.models.MeritRank;
import com.big.backend.repositories.MeritRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeritRankService {

    private final MeritRankRepository _meritRankRepository;

    @Autowired
    public MeritRankService(MeritRankRepository meritRankRepository1) {

        _meritRankRepository = meritRankRepository1;
    }

    //returns all merits sorted by ID
    public List<MeritRank> getAll() {
        try {
            List<MeritRank> meritRanks = _meritRankRepository.findAllByOrderById();
            if (meritRanks == null){
                throw new Exception("No merit ranks in database!");
            }
            return meritRanks;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MeritRank addMeritRank(MeritRank meritRank) {
        return _meritRankRepository.save(meritRank);
    }

    public MeritRank updateMeritRank(MeritRank meritRank){
        return _meritRankRepository.save(meritRank);
    }

    public void deleteMeritRank(Long id) {
        MeritRank merit = _meritRankRepository.findMeritRankById(id);
        if (merit != null){
            _meritRankRepository.deleteMeritRankById(id);
        }
    }
}
