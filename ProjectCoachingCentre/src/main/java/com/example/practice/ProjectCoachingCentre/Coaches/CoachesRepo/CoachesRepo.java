package com.example.practice.ProjectCoachingCentre.Coaches.CoachesRepo;

import com.example.practice.ProjectCoachingCentre.Coaches.Coaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachesRepo extends JpaRepository<Coaches,Integer> {
    Coaches findByName(String name);
}
