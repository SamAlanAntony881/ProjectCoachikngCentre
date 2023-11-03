package com.example.practice.ProjectCoachingCentre.Coaches.CoachesRepo;

import com.example.practice.ProjectCoachingCentre.Coaches.CoachesBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachesBookRepo extends JpaRepository<CoachesBook,Integer> {
}
