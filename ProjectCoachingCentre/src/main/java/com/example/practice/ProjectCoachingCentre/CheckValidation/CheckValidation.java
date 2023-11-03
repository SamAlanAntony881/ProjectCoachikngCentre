package com.example.practice.ProjectCoachingCentre.CheckValidation;

import com.example.practice.ProjectCoachingCentre.Exceptions.ExceptionRequest;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

public class CheckValidation {
    @Value("${username.exception}")
    String use;

    public void checkUserName(String userName) throws ExceptionRequest {
        if(userName.length()>=5&&userName.length()<=8){
            for(int i=0;i<userName.length();i++){
                if(!Character.isDigit(userName.charAt(i))&&!Character.isLetter(userName.charAt(i))&&!Character.isWhitespace(userName.charAt(i))){
                    throw new ExceptionRequest(501,use);
                }
            }
        }
    }
    @Value("${email.exception}")
    String eme;
    public boolean checkEmail(String email) throws ExceptionRequest {
        List<String> modelEmailId = Arrays.asList("gmail.com","hotmail.com","outlook.com");
        String[] subWord;
        subWord = email.split("@");
        boolean check = modelEmailId.contains(subWord[1]);
        if(check)return true;
        else throw new ExceptionRequest(502,eme);
    }
    @Value("${phonenumber.exception}")String phe;
    public boolean checkPhoneNumber(Long phoneNumber) throws ExceptionRequest {
        if(phoneNumber.toString().length()==10)return true;
        else throw new ExceptionRequest(503,phe);
    }
    @Value("${address.exception}")String ade;

    public boolean checkAddress(String address) throws ExceptionRequest {
        if(address.length()>3)return true;
        else throw new ExceptionRequest(504,ade);
    }
    @Value("${status.exception}")String ste;
    public boolean checkStatue(String status) throws ExceptionRequest {
        if(status.equals("Active"))return true;
        else throw new ExceptionRequest(505,ste);
    }
    @Value("${bookinghistory.exception}")String boe;
    public boolean checkBookingHistory(Integer bookingHistory) throws ExceptionRequest {
        if(bookingHistory==0)return true;
        else throw new ExceptionRequest(506,boe);
    }
}
