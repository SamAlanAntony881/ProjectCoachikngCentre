package com.example.practice.ProjectCoachingCentre.Coaches.CoachesService;

import com.example.practice.ProjectCoachingCentre.CheckValidation.CheckValidation;
import com.example.practice.ProjectCoachingCentre.Coaches.Coaches;
import com.example.practice.ProjectCoachingCentre.Coaches.CoachesBook;
import com.example.practice.ProjectCoachingCentre.Coaches.CoachesRepo.CoachesRepo;
import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentre;
import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreRepo.CoachingCentreRepo;
import com.example.practice.ProjectCoachingCentre.Exceptions.ExceptionRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachesService {
    Coaches coaches = new Coaches();
    CoachesBook coachesBook = new CoachesBook();

    public CoachesBook bookNewClass(CoachesBook abc, String name,
                                    CoachesRepo coachesRepo, CoachingCentreRepo centreRepo) throws ExceptionRequest {
        CoachingCentre centre = centreRepo.findByUserName(name);
        CheckValidation checkValidation = new CheckValidation();
        checkValidation.checkUserName(name);
        if(centre !=null) {
            coaches = coachesRepo.findByName(abc.getCoachName());
            if (coaches != null) {
            checkValidation.checkUserName(abc.getCoachName());
                coachesBook.setCoachName(abc.getCoachName());
                List<String> expertise = List.of(coaches.getExpertise().split(","));
                if (expertise.contains(abc.getExpertiseNeeded())) {
                    coachesBook.setExpertiseNeeded(abc.getExpertiseNeeded());
                } else {
                    throw new ExceptionRequest(509, "Expected technology is not available for the mention Coach ");
                }
                List<String> classes = List.of(coaches.getClassesTaken().split(","));
                if (classes.contains(abc.getDayWanted())) {
                    coachesBook.setDayWanted(abc.getDayWanted());
                } else
                    throw new ExceptionRequest(510, "Coach not available on the mention day");

            } else
                throw new ExceptionRequest(404, "Coach's entity is null");

            centre.setBookingHistory(1);
            centreRepo.save(centre);

        }
        else {throw new ExceptionRequest(405,"User not Valid");}
        return coachesBook;
    }

    public List<Coaches> getCoaches(CoachesRepo coachesRepo) {
        return coachesRepo.findAll();
    }

}
