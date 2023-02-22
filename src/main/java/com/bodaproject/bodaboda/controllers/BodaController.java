package com.bodaproject.bodaboda.controllers;

import com.bodaproject.bodaboda.database.BodaRepository;
import com.bodaproject.bodaboda.database.entities.UserModel;
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
import java.util.Optional;



@RestController
@RequestMapping(path= "tkl/ussd/", produces = "application/xml")

public class BodaController {
    @Autowired
    private BodaRepository bodaRepository;

    Logger logger = LogManager.getLogger(BodaController.class);

    @GetMapping
        public String findAllUsers() {
String content = "<page> \n" +
        "Welcome to BodaBoda Tax Services<br/>\n" +
        "<a href=\"ussd/1\">Pay Tax</a><br/>\n" +
        "<a href=\"ussd/2\">Compliance Certiticate</a><br/>\n" +
        "</page>";
        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<!DOCTYPE pages SYSTEM \"cellflash-1.3.dtd\">\n" +
                "<pages>"+content+"</pages>";
    }


    @GetMapping("/1")
    public String numberplate() {
        String content = "<page> \n" +
                "Input "+
                "<form action=\"/tkl/ussd/idnumber\">\n"+
                "<entry kind=\"digits\" var=\"numberplate\">\n" +
               "<prompt>Your Number Plate</prompt> "+
                "</entry>"+
                "</form>"+
                "</page>";
        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<!DOCTYPE pages SYSTEM \"cellflash-1.3.dtd\">\n" +
                "<pages>"+content+"</pages>";
    }
    @GetMapping(value="/idnumber")
    public String idnumber() {
        String content = "<page> \n" +
                "Input "+
                "<form action=\"/tkl/ussd/idnumber.php\">\n"+
                "<entry kind=\"digits\" var=\"numberplate\">\n" +
                "<prompt>Your ID Number</prompt> "+
                "</entry>"+
                "</form>"+
                "</page>";
        return "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<!DOCTYPE pages SYSTEM \"cellflash-1.3.dtd\">\n" +
                "<pages>"+content+"</pages>";
    }


    @GetMapping("/{id}")

    public ResponseEntity<UserModel> findUserById(@PathVariable(value = "id") long id) {
        logger.info("value of id "+id);
        Optional<UserModel> user = bodaRepository.findById(id);
        if (user.isPresent()) {

           // return ResponseEntity.ok().body(user.get());
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        } else {
            return ResponseEntity.notFound().build();

        }


}

    @PostMapping
    public UserModel saveUser(@Validated @RequestBody UserModel user)
    {
        return bodaRepository.save(user);
    }

}
