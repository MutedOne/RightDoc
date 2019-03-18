package com.example.carlmatch.RIGHTDOC;

import java.util.Scanner;

/**
 * Created by Acer on 3/9/2017.
 */

public class RegisteredController {
    private String name;
    private String username;
    private String password;
    private String pass2;
    private String email;
    private int age;


    public RegisteredController(){}
    public RegisteredController(String name, String username, String password, String pass2,String email,int age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.pass2 = pass2;
        this.email = email;
        this.age = age;
    }


    public void setName(String name){
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;

    }
    public void setPass2(String pass2){this.pass2 = pass2;}

    public void setEmail(String email){
        this.email = email;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getPass2(){return pass2;}
    public String getEmail(){
        return email;
    }
    public int getAge(){
        return age;
    }


    public String toString(){
        return getName()+" "+getUsername()+" "+getPassword()+" "+getPass2()+" "+getEmail()+" "+getAge();
    }
    public boolean equals(Object obj){
        boolean flag = false;
        if(obj instanceof RegisteredController){
            RegisteredController temp=(RegisteredController) obj;
            if(this.getName() == temp.getName() && this.getUsername() == temp.getUsername() && this.getPassword() == temp.getPassword() && this.getPass2() == temp.getPass2() && this.getEmail()==temp.getEmail() && this.getAge() == temp.getAge())
                flag =true;
        }
        return flag;
    }
}
