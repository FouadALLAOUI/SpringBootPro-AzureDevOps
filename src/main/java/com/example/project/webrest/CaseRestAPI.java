package com.example.project.webrest;


import com.example.project.entities.Case;
import com.example.project.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // JSON
public class CaseRestAPI {

    @Autowired
    private CaseRepository caseRepository;

    @GetMapping("/cases")
    public List<Case> cases(){
        return caseRepository.findAll();
    }

    @GetMapping("/cases/{id}")
    public Case findCase(@PathVariable Long id){
        return caseRepository.findById(id).orElse(null);
    }

    @PostMapping("/cases")
    public Case saveCase(@RequestBody Case c){
        return caseRepository.save(new Case( c.getTitle(), c.getDescription()));
    }

    @DeleteMapping("/cases/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCase(@PathVariable("id") Long id){
        caseRepository.deleteById(id);
    }

    @PutMapping("/cases/{id}")
    public Case updateCase(@PathVariable("id") Long id, @RequestBody Case c){
        return caseRepository.findById(id)
                .map(uc ->{
                    uc.setTitle(c.getTitle());
                    uc.setDescription(c.getDescription());
                    return  caseRepository.save(uc);
                })
                .orElseGet(() -> {
                    return null;
                });
    }


}
