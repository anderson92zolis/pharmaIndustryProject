package com.apipharma.security.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/demo-controller")
public class DemoController {
    @GetMapping("/test")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from your Api");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String>  sayGoodBye(){
        return ResponseEntity.ok("Bye Bye from your Api");
    }
}
