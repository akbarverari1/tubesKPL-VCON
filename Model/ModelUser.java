/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class ModelUser {
    int Nim;
    String Fullname;
    String Username;
    String Phone;
    String Gender;
    
    public int getNim() {
        return Nim;
    }

    public void setNim(int Nim) {
        this.Nim = Nim;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFull_name(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getUsername() {
        return Fullname;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }  
}
