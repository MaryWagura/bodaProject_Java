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

    @Autowired
    private BodaRepository bodaRepository;

    @GetMapping
    public List<UserModel> findAllUsers()
    {
        return (List<UserModel>) bodaRepository.findAll();
    }

    @GetMapping("/{id}")

    public ResponseEntity<UserModel>findUserById(@PathVariable (value="id") long id)
    {
        Optional<UserModel> user = bodaRepository.findById(id);
        if(user.isPresent())
        {
            return ResponseEntity.ok().body(user.get());
        }else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public UserModel saveUser(@Validated @RequestBody UserModel user)
    {
        return bodaRepository.save(user);
    }

}
