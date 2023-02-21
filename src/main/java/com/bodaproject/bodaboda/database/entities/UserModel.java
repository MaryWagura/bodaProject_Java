package com.bodaproject.bodaboda.database.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity

@Table(name="ownerdetails")
public class UserModel {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    private String numberplate;

    public long getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(long idnumber) {
        this.idnumber = idnumber;
    }

    private long idnumber;

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    private long phonenumber;

    public long getPaymentplan() {
        return paymentplan;
    }

    public void setPaymentplan(long paymentplan) {
        this.paymentplan = paymentplan;
    }

    private long paymentplan;



}
