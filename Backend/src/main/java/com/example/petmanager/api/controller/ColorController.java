package com.example.petmanager.api.controller;

import com.example.petmanager.model.Color;
import com.example.petmanager.service.ColorService;
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
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping("/getColors")
    public ResponseEntity<List<Color>> getAllColors(){
        return colorService.getAllColors();
    }

}
