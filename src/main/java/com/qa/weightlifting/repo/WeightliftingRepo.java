package com.qa.weightlifting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.weightlifting.domain.Weightlifting;

@Repository
public interface WeightliftingRepo extends JpaRepository<Weightlifting, Long> {

}
