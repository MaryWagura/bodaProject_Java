package com.bodaproject.bodaboda.database.entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="ownerdetails")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String numberplate;

    private String idnumber;

    private long phonenumber;

    private long paymentplan;


}
