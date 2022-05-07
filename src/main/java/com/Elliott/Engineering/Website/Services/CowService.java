package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Exceptions.CowNotFoundException;
import com.Elliott.Engineering.Website.Models.Cow;
import com.Elliott.Engineering.Website.Models.Types.CowTypes;
import com.Elliott.Engineering.Website.Repositories.CowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CowService {

    CowRepository cowRepository;

    //get all cows


    @Autowired
    public CowService(CowRepository cowRepository){
        this.cowRepository = cowRepository;
    }

    public Cow getCowByTagNumber(String tagNumber) throws CowNotFoundException {
        Cow cow = this.cowRepository.findCowByTagNumber(tagNumber).orElseThrow(() -> new CowNotFoundException("No cow with that tag number"));

        return cow;
    }

    public List<Cow> getCowByStatus(CowTypes status) throws CowNotFoundException{
        List<Cow> cowList = this.cowRepository.findCowsByStatus(status.toString()).orElseThrow(()->new CowNotFoundException("No cows found"));
        return cowList;
    }

    public List<Cow> getAllCows() throws CowNotFoundException{
        List<Cow> cowList = this.cowRepository.findAllCows().orElseThrow(()->new CowNotFoundException("No cows found"));
        return cowList;
    }

}
