package com.rent.project.productservice.services;

import com.rent.project.productservice.models.category;
import com.rent.project.productservice.repository.categoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {

    @Autowired
    categoryRepo CategoryRepo;

    public ResponseEntity<category> addCategory(category ct)
    {
        CategoryRepo.save(ct);
        return ResponseEntity.ok(ct);
    }

    public ResponseEntity<category> editCategory(Integer id,category ct)
    {
        if(CategoryRepo.findById(id).isPresent())
        {
            ct.setId(id);
            CategoryRepo.save(ct);
            return ResponseEntity.ok(ct);
        }
        return ResponseEntity.notFound().build();
    }
    public void deleteCategory(Integer id){ CategoryRepo.deleteById(id);}

    public List<category> getCategory() {
        return CategoryRepo.findAll();
    }

}
