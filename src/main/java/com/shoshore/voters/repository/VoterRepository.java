package com.shoshore.voters.repository;

import com.shoshore.voters.domain.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
}
