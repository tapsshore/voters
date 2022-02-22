package com.shoshore.voters.service;

import com.shoshore.voters.domain.Voter;
import com.shoshore.voters.dto.VoterToRegisterDto;
import com.shoshore.voters.repository.VoterRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }
    public List<Voter> findAll() {
        return voterRepository.findAll();
    }
    public Optional<Voter> findVoterById(@NonNull Long id) {
        return voterRepository.findById(id);
    }

    public Voter register(@NonNull VoterToRegisterDto voterToRegister) {
        return  null;

    }
}
