package com.bodaproject.bodaboda.services;

import com.bodaproject.bodaboda.database.BodaRepository;
import com.bodaproject.bodaboda.database.entities.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BodaService {
;
    @Autowired
    BodaRepository bodaRepository;

    Logger logger = LogManager.getLogger(BodaService.class);
    String header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
            "<!DOCTYPE pages SYSTEM \"cellflash-1.3.dtd\">\n" +
            "<pages>";
    String footer = "</pages>";

    public String home() {
        return header + "<page>\n" +
                "Welcome to BodaBoda Tax Services<br/>\n" +
                "<a href=\"ussd/1\">Opt In Service</a><br/>\n" +
                "<a href=\"ussd/2\">Compliance Certiticate</a><br/>\n" +
                "</page>" + footer;
    }

    public String page1() {
        String content = "<page>\n" +
                "Input " +
                "<form action=\"/tkl/ussd/input\">\n" +
                "<entry kind=\"digits\" var=\"idnumber\">\n" +
                "<prompt>Your ID Number</prompt> " +
                "</entry>" +
                "</form>" +
                "</page>";
        return header + content + footer;
    }

    public String page2() {
        String content = "<page>\n" +
                "Input " +
                "<form action=\"/tkl/ussd/input\">\n" +
                "<entry kind=\"digits\" var=\"cert\">\n" +
                "<prompt>Compliance certificate number</prompt> " +
                "</entry>" +
                "</form>" +
                "</page>";
        return header + content + footer;
    }

    public String page4() {
        String content = "<page>\n" +
                "Choose a payment plan below:<br/>\n" +
                "<a href=\"/tkl/ussd/payplan/1\">Daily</a><br/>\n" +
                "<a href=\"/tkl/ussd/payplan/2\">Weekly</a><br/>\n" +
                "<a href=\"/tkl/ussd/payplan/3\">Monthly</a><br/>\n" +
                "</page>";

        return header + content + footer;
    }

    public String page5() {
        String content = "<page>\n" +
                "Do you wish to pay with the current number? <br/>\n" +
                "<a href=\"/tkl/ussd/pay/1\">Yes</a><br/>\n" +
                "<a href=\"/tkl/ussd/pay/2\">No</a><br/>\n" +
                "</page>";
        return header + content + footer;
    }

    public String page6() {
        String content = "<page>\n" +
                "Pay(amount set) stk Push\n" +
                "</page>";
        return header + content + footer;
    }

    public String page7() {
        String content = "<page> \n" +
                "Input \n" +
                "<form action=\"/tkl/ussd/input\">\n" +
                "<entry kind=\"digits\" var=\"number\">\n" +
                "<prompt>the number to pay:</prompt>\n" +
                "</entry>\n" +
                "</form>\n" +
                "</page>";
        return header + content + footer;
    }
    public String page8() {
        String content = "<page> \n" +
                "Add \n" +
                "<form action=\"/tkl/ussd/plate/add\">\n" +
                "<entry kind=\"digits\" var=\"plate\">\n" +
                "<prompt>the numberplate:</prompt>\n" +
                "</entry>\n" +
                "</form>\n" +
                "</page>";
        return header + content + footer;
    }

    public String processInput(Map<String, String> input) {

        String page;
        if (input.containsKey("idnumber")) {
            String idnumber = String.valueOf(input.get("idnumber"));
            logger.info(input.get("idnumber"));
            List<UserModel> result = bodaRepository.findByIdnumber(idnumber);
            if (result.isEmpty()) {
                String content = "<page> \n" +
                        "The ID number does not exist.\n" +
                        "<form action=\"/tkl/ussd/input\">\n" +
                        "<entry kind=\"digits\" var=\"idnumber\">\n" +
                        "<prompt>Please try again</prompt>\n" +
                        "</entry>\n" +
                        "</form>\n" +
                        "</page>";

                return header + content + footer;
            } else {
                String platesfromdb = "";
                String diffplate="";
                for (UserModel userModel : result) {
                    platesfromdb += "<a href=\"/tkl/ussd/numplate/" + userModel.getNumberplate() + "\"></a>\n" + userModel.getNumberplate() + "<br/>\n";

                }
                diffplate += "<a href=\"/tkl/ussd/plate\">add numberplate</a><br/>\n";
                String content = "<page>\n" +
                        "Select the numberplate you wish to pay for:<br/>\n"
                        + platesfromdb +
                        diffplate +
                        "</page>";
                return header + content + footer;

                }
            }
        else if (input.containsKey("number")) {
            logger.info(input.get("number"));
            page = page6();
        } else {
            page = "";
        }
        return page;
    }
}


