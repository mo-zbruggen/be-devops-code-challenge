package com.example.notes;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootRedirectController {

    @GetMapping("/")
    public ResponseEntity<Void> redirectToNotes() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/notes");
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
    
}
