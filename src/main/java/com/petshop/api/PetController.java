package com.petshop.api;

import com.petshop.domain.Pet;
import com.petshop.mapper.PetMapper;
import com.petshop.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petshop.domain.ResultInfo;

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
    public ResultInfo<Pet> getPetById(@PathVariable("id") int petId) {
        ResultInfo<Pet> resultInfo = new ResultInfo<Pet>(Constants.Code.DONE, Constants.Message.SUCCESS_MESSAGE, null);
        try {
            Pet pet = petMapper.findPetById(petId);
            resultInfo.setData(pet);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL_MESSAGE);
            return resultInfo;
        }
    }

    @RequestMapping(value = "pet/user/{id}")
    public List<Pet> getPetsByUserId(@PathVariable("id") int userId) {
        return petMapper.findPetByUserId(userId);
    }

    @RequestMapping(value = "pet/insert", method = POST)
    public ResultInfo<Pet> insertPet(Pet pet) {
        ResultInfo<Pet> result = new ResultInfo<Pet>(0, Constants.Message.SUCCESS_MESSAGE, null);
        try {
            petMapper.insertPet(pet);
            return result;
        } catch (Exception e) {
            result.setCode(Constants.Code.GENERAL_ERROR);
            result.setMessage(Constants.Message.FAIL_MESSAGE);
        }
        return result;
    }

    @RequestMapping(value = "pet/update", method = POST)
    public ResultInfo<Pet> updatePet(Pet pet) {
        ResultInfo<Pet> result = new ResultInfo<Pet>(0, Constants.Message.SUCCESS_MESSAGE, null);
        try {
            petMapper.updatePet(pet);
            return result;

        } catch (Exception e) {
            result.setCode(Constants.Code.GENERAL_ERROR);
            result.setMessage(Constants.Message.FAIL_MESSAGE);
        }
        return result;
    }

    @RequestMapping(value = "pet/{id}/delete", method = POST)
    public void deletePet(int petId) {
        petMapper.deletePet(petId);
    }
}
