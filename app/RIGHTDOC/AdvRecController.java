package com.example.carlmatch.RIGHTDOC;

/**
 * Created by Acer on 3/9/2017.
 */

public class AdvRecController {
    private String Name;
    private String Clinic;
    private String ClinicAddress;
    private String Email;
    private String Advice;

    public AdvRecController(String n ,String c, String ca,String em,String ad){
        Name = n;
        Clinic = c;
        ClinicAddress = ca;
        Email = em;
        Advice = ad;
    }

    public String getName() {
        return Name;
    }

    public String getClinic() {
        return Clinic;
    }

    public String getClinicAddress() {
        return ClinicAddress;
    }

    public String getEmail() {
        return Email;
    }

    public String getAdvice() {
        return Advice;
    }
}
