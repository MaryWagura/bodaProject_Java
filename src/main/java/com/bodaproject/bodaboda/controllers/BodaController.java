package com.bodaproject.bodaboda.controllers;

import com.bodaproject.bodaboda.database.BodaRepository;
import com.bodaproject.bodaboda.services.BodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(path = "/tkl/ussd", produces = "text/xml")
public class BodaController {
    @Autowired
    private BodaRepository bodaRepository;
    @Autowired
    BodaService bodaService;


    @GetMapping
    public String getBodaHome() {
        return bodaService.home();
    }

    @GetMapping("/{id}")
    public String getBodaPage(@PathVariable(value = "id") long id) {
        if (id == 1) {

            return bodaService.page1();
        } else {
            return bodaService.page2();
        }
    }


    @GetMapping("/payplan/{id}")
    public String findPaymentPlan(@PathVariable(value = "id") long id) {
        if (id == 1) {
            return bodaService.page5();
        } else if (id == 2) {
            return bodaService.page5();
        } else {
            return bodaService.page5();
        }
    }

    @GetMapping("/pay/{id}")
    public String findPaymentNumber(@PathVariable(value = "id") long id) {
        if (id == 1) {
            return bodaService.page6();
        } else {
            return bodaService.page7();
        }

    }

    @GetMapping("/input")
    public String captureInput(@RequestParam Map<String, String> inputparams) {
        return bodaService.processInput(inputparams);

    }
}






