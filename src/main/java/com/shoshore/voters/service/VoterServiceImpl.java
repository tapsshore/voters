package com.shoshore.voters.service;

import com.shoshore.voters.domain.Voter;
import com.shoshore.voters.dto.ServiceResponse;
import com.shoshore.voters.dto.VoterRegistrationRequest;
import com.shoshore.voters.repository.VoterRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Slf4j
public class VoterServiceImpl implements VoterService{

    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private Mapper mapper;
    ServiceResponse<VoterRegistrationRequest> serviceResponse = new ServiceResponse();

    @Override
    public List<Voter> findAll() {
        return voterRepository.findAll();
    }

    @Override
    public Optional<Voter> findVoterById(@NonNull Long id) {
        return voterRepository.findById(id);
    }

    @Override
    public ResponseEntity<ServiceResponse<VoterRegistrationRequest>> register(@NonNull VoterRegistrationRequest voterRegistrationRequest) {
        Voter voter = mapper.map(voterRegistrationRequest, Voter.class);
        voter=voterRepository.save(voter);
        serviceResponse.setMessage("Voter Registered Successfully");
        serviceResponse.setData(mapper.map(voter, VoterRegistrationRequest.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceResponse);
    }
}
