package com.springboot.localstack.springbootpruebalocalstacks3secretsmanager.controllers;

import com.springboot.localstack.springbootpruebalocalstacks3secretsmanager.services.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddObject {

    private final S3Service s3Service;

    @PostMapping("/add")
    public ResponseEntity<String> add() {

        s3Service.addObject();

        return ResponseEntity.ok()
                .body("Ok");
    }

    @GetMapping("/list")
    public void list() {

        s3Service.listObjects();

    }

}
