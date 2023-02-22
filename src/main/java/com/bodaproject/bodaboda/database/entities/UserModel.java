package com.bodaproject.bodaboda.database.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity

@Table(name="ownerdetails")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String numberplate;

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }


    private long idnumber;
    public long getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(long idnumber) {
        this.idnumber = idnumber;
    }


    private long phonenumber;
    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    private long paymentplan;

    public long getPaymentplan() {
        return paymentplan;
    }

    public void setPaymentplan(long paymentplan) {
        this.paymentplan = paymentplan;
    }





}
