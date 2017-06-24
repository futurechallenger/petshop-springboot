package com.petshop.api;

import com.petshop.domain.Pet;
import com.petshop.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by challenger on 24/6/2017.
 */
@RestController
public class PetController {
    @Autowired
    private PetMapper petMapper;

    @RequestMapping(value = "/pet/{id}")
    public Pet getPetById(@PathVariable("id") int petId) {
        return petMapper.findPetById(petId);
    }

    @RequestMapping(value = "pet/user/{id}")
    public List<Pet> getPetsByUserId(@PathVariable("id") int userId) {
        return petMapper.findPetByUserId(userId);
    }

    @RequestMapping(value = "pet/insert", method = POST)
    public void isnertPet(Pet pet) {
        petMapper.insertPet(pet);
    }

    @RequestMapping(value = "pet/update", method = POST)
    public void updatePet(Pet pet) {
        petMapper.updatePet(pet);
    }

    @RequestMapping(value = "pet/{id}/delete", method = POST)
    public void deletePet(int petId) {
        petMapper.deletePet(petId);
    }
}
