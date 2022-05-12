package com.Elliott.Engineering.Website.Controllers;

import com.Elliott.Engineering.Website.Exceptions.CalfNotFoundException;
import com.Elliott.Engineering.Website.Models.Calf;
import com.Elliott.Engineering.Website.Services.CalfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/calf")
public class CalfController {

    @Autowired
    CalfService calfService;


    @PostMapping("/create")
    public String createCalf(@RequestBody Calf calf, @RequestParam Long userId){
        Calf savedCalf =calfService.saveCalf(calf,userId);
        return "Calf " + savedCalf.getCalfTagNumber() + " saved";
    }


    @GetMapping("/getAll")
    public List<Calf> getAllCalves(@RequestParam Long userId) throws CalfNotFoundException {
        List<Calf> calfList = calfService.findAllCalvesByUserId(userId);
        return calfList;
    }

    @DeleteMapping("/deleteCalf")
    public String deleteCalf(@RequestParam Long calfId){
        String deletedCalf = calfService.deleteCalf(calfId);
        return deletedCalf;
    }
}
