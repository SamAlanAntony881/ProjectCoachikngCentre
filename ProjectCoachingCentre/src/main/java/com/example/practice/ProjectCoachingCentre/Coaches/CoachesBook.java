package com.example.practice.ProjectCoachingCentre.Coaches;

import javax.persistence.*;

@Entity
@Table(name = "coachesbook")
public class CoachesBook {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer coachId;
    String coachName;
    String expertiseNeeded;
    String dayWanted;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getExpertiseNeeded() {
        return expertiseNeeded;
    }

    public void setExpertiseNeeded(String expertiseNeeded) {
        this.expertiseNeeded = expertiseNeeded;
    }

    public String getDayWanted() {
        return dayWanted;
    }

    public void setDayWanted(String dayWanted) {
        this.dayWanted = dayWanted;
    }
}
