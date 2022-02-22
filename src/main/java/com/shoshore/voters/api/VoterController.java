package com.shoshore.voters.api;


import com.shoshore.voters.api.Mappings.Mappings;
import com.shoshore.voters.constants.Constants;
import com.shoshore.voters.domain.Voter;
import com.shoshore.voters.dto.VoterToRegisterDto;
import com.shoshore.voters.service.VoterService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(Mappings.VOTER)
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> register(@RequestBody VoterToRegisterDto voterToRegisterDto) {
            voterService.register(voterToRegisterDto);
            return ResponseEntity.status(HttpStatus.OK).body("voter registered");
    }
}
