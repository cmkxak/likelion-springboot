package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PostMapping(value = "/domain")
    public String postExample(){
        return "Hello Post API";
    }

    @PostMapping("/member")
    //어떤 타입의 데이터 값이 들어올지 모르므로 Object 타입으로 value 지정
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember(@RequestBody MemberDto dto){
        return dto.toString();
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
