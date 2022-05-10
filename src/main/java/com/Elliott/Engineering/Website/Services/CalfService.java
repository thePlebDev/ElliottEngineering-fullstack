package com.Elliott.Engineering.Website.Services;

import com.Elliott.Engineering.Website.Exceptions.CalfNotFoundException;
import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Models.Types.CalfTypes;
import com.Elliott.Engineering.Website.Models.User;
import com.Elliott.Engineering.Website.Repositories.CalfRepository;
import com.Elliott.Engineering.Website.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalfService {


    private CalfRepository calfRepository;
    private UserRepository userRepository;

    @Autowired
    public CalfService(CalfRepository calfRepository, UserRepository userRepository){
        this.calfRepository = calfRepository;
        this.userRepository = userRepository;
    }

    public List<Calf>  findCalfByTagNumber(String tagNumber) throws CalfNotFoundException {
        List<Calf> calf = this.calfRepository.findCalfByTagNumber(tagNumber).orElseThrow(()-> new CalfNotFoundException("No Calves Found"));
        return calf;
    }

    public List<Calf> findCalvesBySex(CalfTypes sex) throws CalfNotFoundException {
        List<Calf> calfList = this.calfRepository.findCalfBySex(sex.toString()).orElseThrow(()-> new CalfNotFoundException("No Calves Found"));
        return calfList;
    }
    public Calf saveCalf(Calf calf,Long userId){
        User foundUser = userRepository.findById(userId).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        calf.setUser(foundUser);
        return this.calfRepository.save(calf);
    }
    public List<Calf> findAllCalvesByCowTagNumber(String tagNumber) throws CalfNotFoundException {
        List<Calf> calfList = this.calfRepository.findAllCalvesByCowTag(tagNumber).orElseThrow(()-> new CalfNotFoundException("No Calves Found"));
        return calfList;
    }
    public String deleteCalf(Long id){
        this.calfRepository.deleteById(id);
        return "Calf deleted";
    }
    public List<Calf> findAllCalvesByUserId(Long id) throws CalfNotFoundException {
        return this.calfRepository.findAllCalvesByUserId(id).orElseThrow(()-> new CalfNotFoundException("no Calves found"));
    }

}
