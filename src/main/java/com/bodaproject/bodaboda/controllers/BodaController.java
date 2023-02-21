package com.bodaproject.bodaboda.controllers;

import com.bodaproject.bodaboda.database.BodaRepository;
import com.bodaproject.bodaboda.database.entities.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "tkl/ussd/", produces = "application/xml")

public class BodaController {

    @GetMapping("/get")
    public ResponseEntity<UserModel> get()
    {
        UserModel model = new UserModel();
         model.getId();
         model.getIdnumber();
         model.getNumberplate();
         model.getPhonenumber();
         model.getPaymentplan();

         HttpHeaders headers =  new HttpHeaders();
         ResponseEntity<UserModel> userModel = new ResponseEntity<>(model,headers,HttpStatus.CREATED);
         return userModel;
    }

    @GetMapping("get/{id}")
    //class
    public ResponseEntity<UserModel> getById(@PathVariable("id") String id)
    {
        UserModel model = new UserModel();
        model.getId();
        model.getIdnumber();
        model.getNumberplate();
        model.getPhonenumber();
        model.getPaymentplan();

        HttpHeaders headers =  new HttpHeaders();
        ResponseEntity<UserModel> userModel = new ResponseEntity<>(model,headers,HttpStatus.CREATED);
        return userModel;

    }



}
