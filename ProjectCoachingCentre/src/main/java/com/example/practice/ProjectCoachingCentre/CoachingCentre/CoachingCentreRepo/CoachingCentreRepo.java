package com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreRepo;

import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachingCentreRepo extends JpaRepository<CoachingCentre,Integer> {
    CoachingCentre findByUserName(String userName);

    boolean existsCoachingCentreByUserName(String userName);
}
