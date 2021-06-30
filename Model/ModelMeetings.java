/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Handler;

/**
 * @author User
 */
public class ModelMeetings {

    int IdMeet;
    String Judul;
    String Host;
    String Passcode;
    Date Schedule;
    int Nim;

    public int getId_meet() {
        return IdMeet;
    }

    public void setId_meet(int IdMeet) {
        this.IdMeet = IdMeet;
    }

    public Date getSchedule() {
        return Schedule;
    }

    public void setSchedule(Date Schedule) {
        this.Schedule = Schedule;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getPasscode() {
        return Passcode;
    }

    public void setPasscode(String Passcode) {
        this.Passcode = Passcode;
    }

    public int getNim() {
        return Nim;
    }

    public void setNim(int Nim) {
        this.Nim = Nim;
    }

}
