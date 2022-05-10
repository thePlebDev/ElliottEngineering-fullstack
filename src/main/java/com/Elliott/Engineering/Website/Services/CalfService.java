package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Exceptions.CalfNotFoundException;
import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Models.Types.CalfTypes;
import com.Elliott.Engineering.Website.Repositories.CalfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalfService {


    private CalfRepository calfRepository;

    @Autowired
    public CalfService(CalfRepository calfRepository){
        this.calfRepository = calfRepository;
    }

    public List<Calf>  findCalfByTagNumber(String tagNumber) throws CalfNotFoundException {
        List<Calf> calf = this.calfRepository.findCalfByTagNumber(tagNumber).orElseThrow(()-> new CalfNotFoundException("Not Calves Found"));
        return calf;
    }

    public List<Calf> findCalvesBySex(CalfTypes sex) throws CalfNotFoundException {
        List<Calf> calfList = this.calfRepository.findCalfBySex(sex.toString()).orElseThrow(()-> new CalfNotFoundException("Not Calves Found"));
        return calfList;
    }

}
