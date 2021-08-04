package com.ncdc.bookrecordstask.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MvcController {
    //end point get by url / root front-end app
    @GetMapping("/")
    public String home(){
        log.info("handling getting index.html");
        return "forward:index.html";
    }
}
