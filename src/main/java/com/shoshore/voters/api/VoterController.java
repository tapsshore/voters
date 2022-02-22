package com.shoshore.voters.api;


import com.shoshore.voters.api.Mappings.Mappings;
import com.shoshore.voters.constants.Constants;
import com.shoshore.voters.domain.Voter;
import com.shoshore.voters.dto.VoterRegistrationRequest;
import com.shoshore.voters.service.VoterService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("api/voter")
public class VoterController {
    @Autowired
    private  VoterService voterService;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());



    @GetMapping("/")
    public List<Voter> getAllVoters() {
        return voterService.findAll();
    }

    @GetMapping("/{id}")
    public Voter getVoter(@PathVariable Long id) {
        return voterService.findVoterById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format(Constants.VOTER_NOT_FOUND_ERROR_MESSAGE, id))
                );
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> register(@RequestBody VoterRegistrationRequest voterRegistrationRequest) {
            voterService.register(voterRegistrationRequest);
            return ResponseEntity.status(HttpStatus.OK).body("voter registered");
    }
}
