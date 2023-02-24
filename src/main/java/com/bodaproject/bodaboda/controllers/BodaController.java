package com.bodaproject.bodaboda.controllers;

import com.bodaproject.bodaboda.database.BodaRepository;
import com.bodaproject.bodaboda.database.entities.UserModel;
import com.bodaproject.bodaboda.services.BodaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(path = "/tkl/ussd", produces = "text/xml")

public class BodaController {
    @Autowired
    private BodaRepository bodaRepository;
    @Autowired
    BodaService bodaService;

    Logger logger = LogManager.getLogger(BodaController.class);

    @GetMapping
    public String findAllUsers() {
        return bodaService.home();
    }

    @GetMapping("/{id}")
    public String findUserById(@PathVariable(value = "id") long id) {
        if (id==1) {
            return bodaService.page1();
        } else if (id==2) {
            return bodaService.page2();
        }
        return null;
    }
   @GetMapping("/payplan/{id}")
   public String findPaymentPlan(@PathVariable(value = "id") long id)
   {
        if (id==1)
        {
           return bodaService.page5();
       } else if (id==2) {
           return bodaService.page5();
       }else if (id==3) {
           return bodaService.page5();
       }
       return null;
   }
    @GetMapping("/pay/{id}")
    public String findPaymentNumber(@PathVariable(value = "id") long id)
    {
         if (id==1)
        {
            return bodaService.page6();
        } else if (id==2) {
            return bodaService.page7();
        }
        return null;

    }
     @GetMapping("/input")
    public String captureInput(@RequestParam Map<String,String> inputparams) {
         return bodaService.processInput(inputparams);
//             bodaService.page3();

    }


    @PostMapping
    public UserModel saveUser(@Validated @RequestBody UserModel user) {
        return bodaRepository.save(user);
    }



}
