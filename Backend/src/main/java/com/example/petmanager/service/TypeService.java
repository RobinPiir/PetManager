package com.example.petmanager.service;

import com.example.petmanager.model.Pet;
import com.example.petmanager.model.Type;
import com.example.petmanager.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public ResponseEntity<List<Type>> getAllTypes(){
        try{
            List<Type> typeList = new ArrayList<>(typeRepository.findAll());

            if (typeList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(typeList, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
