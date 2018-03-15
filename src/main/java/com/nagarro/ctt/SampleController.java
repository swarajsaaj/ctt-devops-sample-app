package com.nagarro.ctt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/")
    public String getData(){
        return "Ctt Test assigment";
    }
}
