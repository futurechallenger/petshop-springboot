package com.petshop.api;

import com.petshop.domain.Pet;
import com.petshop.mapper.PetMapper;
import com.petshop.utils.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/pet/{id}")
    public ResultInfo<Pet> getPetById(@PathVariable("id") int petId) {
        ResultInfo<Pet> resultInfo = new ResultInfo<Pet>(Constants.Code.DONE, Constants.Message.SUCCESS, null);
        try {
            Pet pet = petMapper.findPetById(petId);
            resultInfo.setData(pet);
            return resultInfo;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL);
            return resultInfo;
        }
    }

    @RequestMapping(value = "pet/user/{id}")
    public ResultInfo<List<Pet>> getPetsByUserId(@PathVariable("id") int userId) {
        ResultInfo<List<Pet>> resultInfo = new ResultInfo<List<Pet>>(Constants.Code.DONE, Constants.Message.SUCCESS,
                null);
        try {
            List<Pet> data = petMapper.findPetByUserId(userId);
            resultInfo.setData(data);
            return resultInfo;
        } catch (Exception e) {
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL);
            return resultInfo;
        }
    }

    @RequestMapping(value = "pet/insert", method = POST)
    public ResultInfo<Pet> insertPet(@RequestBody Pet pet) { //TODO: Chinese character is not recognized.
        logger.debug("request body {}", pet);
        ResultInfo<Pet> result = new ResultInfo<Pet>(0, Constants.Message.SUCCESS, null);
        try {
            petMapper.insertPet(pet);
            return result;
        } catch (Exception e) {
            logger.error("ERROR {}", e);
            result.setCode(Constants.Code.GENERAL_ERROR);
            result.setMessage(Constants.Message.FAIL);
        }
        return result;
    }

    @RequestMapping(value = "pet/update", method = POST)
    public ResultInfo<Pet> updatePet(@RequestBody Pet pet) {
        ResultInfo<Pet> result = new ResultInfo<Pet>(Constants.Code.DONE, Constants.Message.SUCCESS, null);
        try {
            petMapper.updatePet(pet);
            return result;

        } catch (Exception e) {
            result.setCode(Constants.Code.GENERAL_ERROR);
            result.setMessage(Constants.Message.FAIL);
        }
        return result;
    }

    @RequestMapping(value = "pet/{id}/delete", method = POST)
    public ResultInfo<Pet> deletePet(int petId) {
        ResultInfo<Pet> resultInfo = new ResultInfo<Pet>(Constants.Code.DONE, Constants.Message.SUCCESS, null);
        try {
            petMapper.deletePet(petId);
            return resultInfo;
        } catch (Exception e) {
            resultInfo.setCode(Constants.Code.GENERAL_ERROR);
            resultInfo.setMessage(Constants.Message.FAIL);
            return resultInfo;
        }
    }
}
