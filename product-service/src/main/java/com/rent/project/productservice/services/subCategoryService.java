package com.rent.project.productservice.services;

import com.rent.project.productservice.models.subCategory;
import com.rent.project.productservice.repository.subCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subCategoryService {
    @Autowired
    subCategoryRepo scr;

    public ResponseEntity<subCategory> addsubCategory(subCategory sc)
    {
        scr.save(sc);
        return ResponseEntity.ok(sc);
    }

    public ResponseEntity<subCategory> editsubCategory(Integer id,subCategory sc)
    {
        if(scr.findById(id).isPresent())
        {
            sc.setId(id);
            scr.save(sc);
            return ResponseEntity.ok(sc);
        }
        return ResponseEntity.notFound().build();
    }
    public void deletesubCategory(Integer id){ scr.deleteById(id);}

    public List<subCategory> getsubCategory() {
        return scr.findAll();
    }

}
