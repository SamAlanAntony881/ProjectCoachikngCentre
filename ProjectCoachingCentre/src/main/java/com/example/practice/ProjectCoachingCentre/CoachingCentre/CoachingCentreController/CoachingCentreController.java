package com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreController;

import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentre;
import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreRepo.CoachingCentreRepo;
import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreService.CoachingCentreService;
import com.example.practice.ProjectCoachingCentre.Exceptions.ExceptionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoachingCentreController {
    Logger logger = LoggerFactory.getLogger(CoachingCentreController.class);
    CoachingCentreService coachingCentreService = new CoachingCentreService();
    @Autowired
    CoachingCentreRepo coachingCentreRepo;
    @PostMapping("/register")

    public CoachingCentre newUser(@RequestBody CoachingCentre student) throws ExceptionRequest {
        logger.info("Adding new user");
        CoachingCentre newStudent = coachingCentreService.createUser(student,coachingCentreRepo);
        return newStudent;
    }
    @GetMapping("/getuser")
    public List<CoachingCentre> get(){
        logger.info("Getting all users");
        return  coachingCentreService.getall(coachingCentreRepo);
    }
    @GetMapping("/getuser/{userName}")
    public CoachingCentre getuser(@PathVariable String userName) throws ExceptionRequest {
        return  coachingCentreService.getByUserName(userName,coachingCentreRepo);

    }
    @PutMapping("/edituser/{userName}")
    public CoachingCentre updateUser(@PathVariable String userName,@RequestBody CoachingCentre user) throws ExceptionRequest {
        return coachingCentreService.editByUserName(userName,coachingCentreRepo,user);
    }
   @DeleteMapping("/deleteuser/{userName}")
   public String deleteUser(@PathVariable String userName,@RequestParam String retainRecord) throws ExceptionRequest {

       return coachingCentreService.deleteUser(userName,retainRecord,coachingCentreRepo);
    }

}
