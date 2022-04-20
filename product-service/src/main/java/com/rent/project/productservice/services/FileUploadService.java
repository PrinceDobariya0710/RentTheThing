package com.rent.project.productservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {

    public String uploadFile(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\bbdnet10198\\Desktop\\ProjectSpringBoot\\RentTheThing\\uploads\\" + file.getOriginalFilename()));
        return file.getOriginalFilename();
    }
}
