package com.rent.project.productservice.controller;

import com.rent.project.productservice.models.subCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class subCategoryController {

    @Autowired
    com.rent.project.productservice.services.subCategoryService subCategoryService;

    @PostMapping("/add")
    public ResponseEntity<subCategory> addsubcategory(@RequestBody subCategory sb)
    {
        return subCategoryService.addsubCategory(sb);
    }

    @PutMapping("/edit/{Id}")
    public ResponseEntity<subCategory> editsubcategory(@PathVariable Integer Id,@RequestBody subCategory sb){
        return subCategoryService.editsubCategory(Id,sb);
    }
    @DeleteMapping("/delete/{Id}")
    public void deletesubcategory(@PathVariable Integer Id)
    {
        subCategoryService.deletesubCategory(Id);
    }
    @GetMapping ("/all")
    public List<subCategory> getsubcategories() {
        return subCategoryService.getsubCategory();
    }
}
