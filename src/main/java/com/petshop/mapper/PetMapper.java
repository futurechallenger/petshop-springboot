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
    @Insert("INSERT INTO pet (name, type, quantity, price, userId, accessoryId, deleted, updatedBy, updatedAt) VALUES (#{pet.name}, #{pet.})")
    void insertPet(Pet pet);

    void updatePet(Pet pet);

    void findPetbyId(Integer petId);

    List<Pet> findPetByUserId(Integer userId);

    void deletePet(Integer petId);
}
