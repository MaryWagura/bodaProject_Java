package com.bodaproject.bodaboda.database.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="ownerdetails")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numberplate;
     private long idnumber;
     private long phonenumber;
     private long paymentplan;



}
