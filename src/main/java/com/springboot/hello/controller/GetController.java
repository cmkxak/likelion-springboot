package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {

    @GetMapping("/hello")
    public String hello(){
        log.info("Hello 요청이 들어왔습니다.");
        return "hello";
    }

    @GetMapping("/name")
    public String name(){
        return "Flature!";
    }

    @GetMapping("/variable1/{variable1}")
    public String getVariable1(@PathVariable String variable1){
        log.info("getvariable1로 요청이 들어왔습니다. {}", variable1);
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

    @GetMapping("/request2")
    public String getRequestParamByMap(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestparam(MemberDto memberDTO){
        return memberDTO.toString();
    }

}
