package com.shoshore.voters.service;

import com.shoshore.voters.domain.Voter;
import com.shoshore.voters.dto.ServiceResponse;
import com.shoshore.voters.dto.VoterRegistrationRequest;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VoterService {

    List<Voter> findAll();
    Optional<Voter> findVoterById(@NonNull Long id);
    ResponseEntity<ServiceResponse<VoterRegistrationRequest>> register(@NonNull VoterRegistrationRequest voterToRegister);
}
