package com.c1646njava.tuvivienda.services.implementation;

import com.c1646njava.tuvivienda.models.image.Image;
import com.c1646njava.tuvivienda.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageServiceImp {

    private ImageRepository imageRepository;

    public List<Image> list(){
        return imageRepository.findByOrderById();
    }

    public Optional<Image> getOne(Long id){
        return imageRepository.findById(id);
    }
    public void save(Image image){
        imageRepository.save(image);
    }

    public void delete(Long id){
        imageRepository.deleteById(id);
    }
    public boolean exists(Long id){ return imageRepository.existsById(id);
    }
}
