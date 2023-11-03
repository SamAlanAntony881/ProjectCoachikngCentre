package com.example.practice.ProjectCoachingCentre.Coaches.CoachesController;

import com.example.practice.ProjectCoachingCentre.Coaches.Coaches;
import com.example.practice.ProjectCoachingCentre.Coaches.CoachesBook;
import com.example.practice.ProjectCoachingCentre.Coaches.CoachesRepo.CoachesBookRepo;
import com.example.practice.ProjectCoachingCentre.Coaches.CoachesRepo.CoachesRepo;
import com.example.practice.ProjectCoachingCentre.Coaches.CoachesService.CoachesService;
import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreRepo.CoachingCentreRepo;
import com.example.practice.ProjectCoachingCentre.Exceptions.ExceptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachesController {
    @Autowired
    CoachesService coachesService;
    @Autowired
    CoachingCentreRepo centreRepo;
    @Autowired
    CoachesRepo coachesRepo;
    @Autowired
    CoachesBookRepo coachesBookRepo;
    @PostMapping("/bookclass/{userName}")
    public CoachesBook newClass(@RequestBody CoachesBook coachesBook, @PathVariable String userName) throws ExceptionRequest {
         CoachesBook coachesBook1 = coachesService.bookNewClass(coachesBook,userName,coachesRepo,centreRepo);
         coachesBookRepo.save(coachesBook1);
         if(coachesBook1 == null)
             throw new ExceptionRequest(406,"Coaches Booking entity is NULL");
         else
             return coachesBook1;
    }
    @GetMapping("getcoaches")
    public List<Coaches> getAll(){
        return coachesService.getCoaches(coachesRepo);
    }

}
