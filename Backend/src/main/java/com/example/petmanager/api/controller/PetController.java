package com.example.petmanager.api.controller;

import com.example.petmanager.model.Pet;
import com.example.petmanager.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping("/pet/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable int id){
        return petService.getPet(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Pet>> getAllPets(){
        return petService.getAllPets();
    }

    @PostMapping("/addPet")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

    @PostMapping("/updatePet/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable int id, @RequestBody Pet newPet){
        return petService.updatePet(id, newPet);
    }

    @DeleteMapping("/deletePet/{id}")
    public ResponseEntity<HttpStatus> deletePet(@PathVariable int id){
        return petService.deletePet(id);
    }
}
