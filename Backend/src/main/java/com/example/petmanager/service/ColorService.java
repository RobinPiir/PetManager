package com.example.petmanager.service;

import com.example.petmanager.model.Color;
import com.example.petmanager.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {
    @Autowired
    private ColorRepository colorRepository;

    public ResponseEntity<List<Color>> getAllColors(){
        try{
            List<Color> colorList = new ArrayList<>(colorRepository.findAll());

            if (colorList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(colorList, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
