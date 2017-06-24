package com.petshop.mapper;

import com.petshop.domain.Pet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by challenger on 24/6/2017.
 */
public interface PetMapper {
    void insertPet(Pet pet);

    void updatePet(Pet pet);

    Pet findPetById(Integer petId);

    List<Pet> findPetByUserId(Integer userId);

    void deletePet(Integer petId);
}
