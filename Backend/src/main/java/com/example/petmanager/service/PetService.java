package com.example.petmanager.service;

import com.example.petmanager.model.Pet;
import com.example.petmanager.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public ResponseEntity<Pet> getPet(int id){
        Optional<Pet> petData =  petRepository.findById(id);
        if (petData.isPresent()){
            return new ResponseEntity<>(petData.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Pet>> getAllPets(){
        try{
            List<Pet> petList = new ArrayList<>(petRepository.findAll());

            if (petList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(petList, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Pet> addPet(Pet pet){
        Pet petObj = petRepository.save(pet);

        return new ResponseEntity<>(petObj, HttpStatus.OK);
    }

    public ResponseEntity<Pet> updatePet(int id, Pet newPet){
        Optional<Pet> petData = petRepository.findById(id);

        if (petData.isPresent()){
            Pet updatedPet = petData.get();
            updatedPet.setName(newPet.getName());
            updatedPet.setType(newPet.getType());
            updatedPet.setColor(newPet.getColor());

            Pet petObj = petRepository.save(updatedPet);
            return new ResponseEntity<>(petObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> deletePet(int id){
        petRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}