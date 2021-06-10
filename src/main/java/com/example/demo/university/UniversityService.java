package com.example.demo.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    public void addNewUniversity(University university) {
        Optional<University> universityOptional = universityRepository.findUniversityByName(university.getName());
        if (universityOptional.isPresent()) {
            throw new IllegalStateException("University already exist!");
        }
        universityRepository.save(university);
    }

    public void deleteUniversity(Long universityId) {
        boolean exists = universityRepository.existsById(universityId);
        if (!exists) {
            throw new IllegalStateException("University with id " + universityId + " does not exist!");
        }
        universityRepository.deleteById(universityId);
    }

    @Transactional
    public void updateUniversity(Long universityId, String name, String country, String city) {
        University university = universityRepository.findById(universityId).orElseThrow(() ->
                new IllegalStateException("University with id " + universityId + " does not exist!"));
        if (name != null && name.length() > 0 &&
                !Objects.equals(university.getName(), name)) {
            university.setName(name);
        }
        if (country != null && country.length() > 0 &&
                !Objects.equals(university.getCountry(), country)) {
            university.setCountry(country);
        }
        if (city != null && city.length() > 0 &&
                !Objects.equals(university.getCity(), city)) {
            university.setCity(city);
        }


    }
}
