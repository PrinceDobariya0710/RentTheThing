package com.rent.project.productservice.controller;

import com.rent.project.productservice.models.category;
import com.rent.project.productservice.services.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class categoryController {

    @Autowired
    categoryService cs;

    @PostMapping("/add")
    public ResponseEntity<category> addcategory(@RequestBody category cg)
    {
        return cs.addCategory(cg);
    }

    @PutMapping("/edit/{Id}")
    public ResponseEntity<category> editcategory(@PathVariable Integer Id,@RequestBody category cg){
        return cs.editCategory(Id,cg);
    }
    @DeleteMapping("/delete/{Id}")
    public void deletecategory(@PathVariable Integer Id)
    {
        cs.deleteCategory(Id);
    }
    @GetMapping ("/all")
    public List<category> getcategories() {
        return cs.getCategory();
    }
}
