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
    public List<University> getUniversity() {
        return universityService.getUniversities();
    }

    @PostMapping
    public void registerNewUniversity(@RequestBody University university) {
        universityService.addNewUniversity(university);
    }

    @DeleteMapping(path = "{universityId}")
    public void deleteUniversity(
            @PathVariable("universityId") Long universityId) {
        universityService.deleteUniversity(universityId);
    }

    @PutMapping(path = "{universityId}")
    public void updateUniversity(
            @PathVariable("universityId") Long universityId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city
    ) {
        universityService.updateUniversity(universityId, name, country, city);
    }

}
