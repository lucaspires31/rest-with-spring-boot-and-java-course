package br.com.lucaspires31.controllers;


import br.com.lucaspires31.services.PersonServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/test/v1")

public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping
    public String testLog() {
        logger.debug("This is debud log");
        logger.info("This is info log");
        logger.warn("This is warning log");
        logger.error("This is error log");
        return "Logs generate sucessfully";

    }
}
