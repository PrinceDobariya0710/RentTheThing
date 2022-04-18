package com.rent.project.productservice.services;

import com.rent.project.productservice.models.productDurationRate;
import com.rent.project.productservice.repository.productDurationRateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productDurationRateService {
    @Autowired
    productDurationRateRepo durationRateRepo;

    public ResponseEntity<productDurationRate> addDuration(productDurationRate pdr)
    {
        durationRateRepo.save(pdr);
        return ResponseEntity.ok(pdr);
    }

    public ResponseEntity<productDurationRate> editDuration(Integer id,productDurationRate pdr)
    {
        if(durationRateRepo.findById(id).isPresent())
        {
            pdr.setId(id);
            durationRateRepo.save(pdr);
            return ResponseEntity.ok(pdr);
        }
        return ResponseEntity.notFound().build();
    }
    public void deleteDuration(Integer id){ durationRateRepo.deleteById(id);}

    public List<productDurationRate> getDuration() {
        return durationRateRepo.findAll();
    }
}
