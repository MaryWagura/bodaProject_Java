package com.bodaproject.bodaboda.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BodaService {
        Logger logger = LogManager.getLogger(BodaService.class);
    String header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
            "<!DOCTYPE pages SYSTEM \"cellflash-1.3.dtd\">\n" +
            "<pages>";
    String footer = "</pages>";

    public String home() {
        return header + "<page> \n" +
                "Welcome to BodaBoda Tax Services<br/>\n" +
                "<a href=\"ussd/1\">Pay Tax</a><br/>\n" +
                "<a href=\"ussd/2\">Compliance Certiticate</a><br/>\n" +
                "</page>" + footer;
    }

    public String page1() {
        String content = "<page> \n" +
                "Input " +
                "<form action=\"/tkl/ussd/input\">\n" +
                "<entry kind=\"digits\" var=\"numberplate\">\n" +
                "<prompt>Your Number Plate</prompt> " +
                "</entry>" +
                "</form>" +
                "</page>";
        return header + content + footer;
    }
    public String page2() {
        String content = "<page> \n" +
                "Input " +
                "<form action=\"/tkl/ussd/input\">\n" +
                "<entry kind=\"digits\" var=\"cert\">\n" +
                "<prompt>Compliance certificate number</prompt> " +
                "</entry>" +
                "</form>" +
                "</page>";
        return header + content + footer;
    }

    public void processInput(Map<String,String> input){
        if(input.containsKey("numberplate")) {
            logger.info(input.get("numberplate"));
        } else {
            logger.info(input.get("idnumber"));
        }
    }
}
