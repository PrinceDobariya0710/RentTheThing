package com.rent.project.productservice.controller;

import com.rent.project.productservice.models.productDurationRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duration")
public class productDurationRateController {
    @Autowired
    com.rent.project.productservice.services.productDurationRateService productDurationRateService;

    @PostMapping("/add")
    public ResponseEntity<productDurationRate> addDuration(@RequestBody productDurationRate productDurationRate)
    {
        return productDurationRateService.addDuration(productDurationRate);
    }

    @PutMapping("/edit/{Id}")
    public ResponseEntity<productDurationRate> editDuration(@PathVariable Integer Id,@RequestBody productDurationRate productDurationRate){
        return productDurationRateService.editDuration(Id,productDurationRate);
    }
    @DeleteMapping("/delete/{Id}")
    public void deleteDuration(@PathVariable Integer Id)
    {
        productDurationRateService.deleteDuration(Id);
    }
    @GetMapping ("/all")
    public List<productDurationRate> getDuration() {
        return productDurationRateService.getDuration();
    }
}
