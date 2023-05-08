package com.example.petmanager.api.controller;

import com.example.petmanager.model.Type;
import com.example.petmanager.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/getTypes")
    public ResponseEntity<List<Type>> getAllTypes(){
        return typeService.getAllTypes();
    }
}
