package com.example.demo.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities(){
        return universityRepository.findAll();
    }

    public void addNewUniversity(University university) {
        Optional<University> universityOptional = universityRepository.findUniversityByName(university.getName());
        if(universityOptional.isPresent()){
            throw new IllegalStateException("University already exist!");
        }
        universityRepository.save(university);
    }
}
