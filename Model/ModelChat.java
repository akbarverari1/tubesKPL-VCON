/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author sada technology
 */
public class ModelChat {

    int IdChat;
    String Message;
    Date Date;
    String PassCode;

    public int getIdChat() {
        return IdChat;
    }

    public void setId_chat(int IdChat) {
        this.IdChat = IdChat;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getPassCode() {
        return PassCode;
    }

    public void setPassCode(String PassCode) {
        this.PassCode = PassCode;
    }
    
    
}
