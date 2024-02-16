package com.c1646njava.tuvivienda.controllers;

import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.repositories.PostRepository;
import com.c1646njava.tuvivienda.services.abstraction.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.c1646njava.tuvivienda.repositories.PostRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    private PostService postservicio;

    @GetMapping("/findByName/{address}")
    public ResponseEntity<?> searchByLocation(@PathVariable String address){
        Optional<List<Post>> posts = postservicio.searchByLocation(address);
        if(posts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay propiedades con la dirección: " + address);
        }else{
            return ResponseEntity.ok(posts);
        }
    }

    @GetMapping("/findByType/{type}")
    public ResponseEntity<?> searchByType(@PathVariable String type){
        Optional<List<Post>> posts = postservicio.searchByType(type);

        if(posts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay propiedades del tipo: " + type);
        }else{
            return ResponseEntity.ok(posts);
        }
    }

    @GetMapping("/findByBedrooms/{bedrooms}")
    public ResponseEntity<?>  searchByBedrooms(@PathVariable int bedrooms){
        Optional<List<Post>> posts = postservicio.searchByBedrooms(bedrooms);

        if(posts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay propiedades con: " + bedrooms + " habitaciones");
        }else{
            return ResponseEntity.ok(posts);
        }
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<?>  searchByPrice(@RequestParam(name = "lowprice") Long lowprice, @RequestParam(name = "highprice") Long highprice){
        Optional<List<Post>> posts = postservicio.searchByPrice(lowprice, highprice);

        if(posts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay propiedades con un precio entre " + lowprice + " - " + highprice);
        }else{
            return ResponseEntity.ok(posts);
        }

    }





}
