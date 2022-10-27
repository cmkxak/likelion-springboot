package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-api")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/name")
    public String name(){
        return "Flature!";
    }

    @GetMapping("/variable1/{variable1}")
    public String getVariable1(@PathVariable String variable1){
        return variable1;
    }

    @GetMapping("/variable2/{variable2}")
    public String variable2(@PathVariable("variable2") String var){
        return var;
    }

    @GetMapping("/request1")
    public String getRequestParam(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return name + " " + email + " " + organization;
    }
}
