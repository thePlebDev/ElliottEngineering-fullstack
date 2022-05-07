package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Exceptions.HerdNotFoundException;
import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Models.Herd;
import com.Elliott.Engineering.Website.Repositories.HerdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerdService {

    private HerdRepository herdRepository;


    @Autowired
    public HerdService(HerdRepository herdRepository){
        this.herdRepository = herdRepository;
    }

    public List<Herd> getAllHerds() throws HerdNotFoundException {
        List<Herd>  herd = this.herdRepository.findAllHerd().orElseThrow(()-> new HerdNotFoundException("No herds found"));
        return herd;
    }
}
