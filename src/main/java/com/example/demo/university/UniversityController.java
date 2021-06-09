package com.example.demo.university;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/university")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getUniversity(){
      return universityService.getUniversities();
    }

    @PostMapping
    public void registerNewUniversity(@RequestBody University university){
        universityService.addNewUniversity(university);
    }

}
