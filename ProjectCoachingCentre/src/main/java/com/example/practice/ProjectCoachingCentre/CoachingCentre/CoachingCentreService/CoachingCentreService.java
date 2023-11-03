package com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreService;
import com.example.practice.ProjectCoachingCentre.CheckValidation.CheckValidation;
import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentre;
import com.example.practice.ProjectCoachingCentre.CoachingCentre.CoachingCentreRepo.CoachingCentreRepo;
import com.example.practice.ProjectCoachingCentre.Exceptions.ExceptionRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CoachingCentreService {
    public CoachingCentre createUser(CoachingCentre abc, CoachingCentreRepo coachingCentreRepo) throws ExceptionRequest {
        boolean b = false ;
        CoachingCentre coachingCentre = new CoachingCentre();
        CheckValidation checkValidation = new CheckValidation();
        coachingCentre.setUserId(abc.getUserId());
        coachingCentre.setUserName(abc.getUserName());
        checkValidation.checkUserName(abc.getUserName());
        coachingCentre.setEmail(abc.getEmail());
        checkValidation.checkEmail(abc.getEmail());
        coachingCentre.setPhoneNumber(abc.getPhoneNumber());
        checkValidation.checkPhoneNumber(abc.getPhoneNumber());
        coachingCentre.setAddress(abc.getAddress());
        checkValidation.checkAddress(abc.getAddress());
        coachingCentre.setStatus(abc.getStatus());
        checkValidation.checkStatue(abc.getStatus());
        coachingCentre.setBookingHistory(abc.getBookingHistory());
        checkValidation.checkBookingHistory(abc.getBookingHistory());
        if(!coachingCentreRepo.existsCoachingCentreByUserName(abc.getUserName())) {
            b = true;
            coachingCentreRepo.save(coachingCentre);
        }
        else {
            b = false;
            throw new ExceptionRequest(509,"User exists in the Repository");
        }if(b)
        return coachingCentre;
        else return null;

    }


    public List<CoachingCentre> getall(CoachingCentreRepo repo) {
        return repo.findAll();
    }


    public CoachingCentre getByUserName(String userName, CoachingCentreRepo coachingCentreRepo) throws ExceptionRequest {
        CoachingCentre coachingCentre = coachingCentreRepo.findByUserName(userName);
        if (coachingCentre == null) {
            throw new ExceptionRequest(507, "User not available ");
        } else return coachingCentre;
    }

    public CoachingCentre editByUserName(String userName, CoachingCentreRepo coachingCentreRepo, CoachingCentre abc) throws ExceptionRequest {
        CoachingCentre coachingCentre = coachingCentreRepo.findByUserName(userName);
        if (coachingCentre == null) throw new ExceptionRequest(508, "User not found and cannot be edited");
        CheckValidation checkValidation = new CheckValidation();
        if (abc.getUserId() != null)
            coachingCentre.setUserId(abc.getUserId());
        else if (abc.getEmail() != null) {
            coachingCentre.setEmail(abc.getEmail());
            checkValidation.checkEmail(abc.getEmail());
        } else if (abc.getPhoneNumber() != null) {
            coachingCentre.setPhoneNumber(abc.getPhoneNumber());
            checkValidation.checkPhoneNumber(abc.getPhoneNumber());
        } else if (abc.getAddress() != null) {
            coachingCentre.setAddress(abc.getAddress());
            checkValidation.checkAddress(abc.getAddress());
        } else if (abc.getStatus() != null) {
            coachingCentre.setStatus(abc.getStatus());
            checkValidation.checkStatue(abc.getStatus());
        } else if (abc.getBookingHistory() != null) {
            coachingCentre.setBookingHistory(abc.getBookingHistory());
            checkValidation.checkBookingHistory(abc.getBookingHistory());
        }
        coachingCentreRepo.save(coachingCentre);

        return coachingCentre;
    }

    public String deleteUser(String userName, String retainRecord, CoachingCentreRepo coachingCentreRepo) throws ExceptionRequest {
        CoachingCentre coachingCentre = new CoachingCentre();
        List<String> yesString = Arrays.asList("YES", "Yes", "yes");
        List<String> noString = Arrays.asList("NO", "No", "no");
        boolean a = true;
        if (yesString.contains(retainRecord)) {
            coachingCentre = coachingCentreRepo.findByUserName(userName);
            if(coachingCentre==null)throw new ExceptionRequest(508,"User not available");
            coachingCentreRepo.delete(coachingCentre);
            a = true;
        } else if(noString.contains(retainRecord)) {
             coachingCentre = coachingCentreRepo.findByUserName(userName);
            coachingCentre.setStatus("Inactive");
            coachingCentreRepo.save(coachingCentre);
            a = false;
        }
        if(a)return "Deletion Success";
        else {
            return "Status updated"+ coachingCentre.getStatus();
        }
    }
}




