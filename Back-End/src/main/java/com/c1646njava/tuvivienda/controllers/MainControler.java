package com.c1646njava.tuvivienda.controllers;

import com.c1646njava.tuvivienda.models.image.Image;
import com.c1646njava.tuvivienda.models.image.dto.Mensaje;
import com.c1646njava.tuvivienda.repositories.ImageRepository;
import com.c1646njava.tuvivienda.services.implementation.CloudinaryServiceImp;
import com.c1646njava.tuvivienda.services.implementation.ImageServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
@RequiredArgsConstructor
public class MainControler {

    private final CloudinaryServiceImp cloudinaryServiceImp;
    private final ImageServiceImp imageServiceImp;
    private final ImageRepository imageRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Image>> list(){
        List<Image> list = imageServiceImp.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException{
    BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
    if(bi == null){
        return new ResponseEntity<>(new Mensaje("No valid image"), HttpStatus.BAD_REQUEST);
    }
        Map result = cloudinaryServiceImp.upload(multipartFile);
    Image image =
            new Image((String)result.get("original_filename"),
            (String) result.get("url"),
            (String) result.get("public_id"));
    imageRepository.save(image);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws IOException{
        if(!imageRepository.existsById(id)){
            return new ResponseEntity<>(new Mensaje("The image does not exist"), HttpStatus.NOT_FOUND);
        }

        Image image = imageRepository.findById(id).get();
        Map result = cloudinaryServiceImp.delete(image.getImageId());
        imageRepository.deleteById(id);
        return new ResponseEntity<>(new Mensaje("The image has been deleted"), HttpStatus.OK);
    }
}
