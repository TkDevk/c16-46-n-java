package com.c1646njava.tuvivienda.controllers;

import com.c1646njava.tuvivienda.controllers.Abstraction.PostControllerA;
import com.c1646njava.tuvivienda.exeptions.PostExceptions.badRequestException;
import com.c1646njava.tuvivienda.exeptions.PostExceptions.entityCreationException;
import com.c1646njava.tuvivienda.exeptions.PostExceptions.postNotFoundException;
import com.c1646njava.tuvivienda.models.post.DTO.FilterDTO;
import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.services.abstraction.PostService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/post")
public class PostController implements PostControllerA {

    private PostService postservicio;

    public PostController(PostService postservicio) {
        this.postservicio = postservicio;

    }
    @Override
    @GetMapping("/searchByFilter")
    public ResponseEntity<Page<Post>> getByFilter(@RequestBody List<FilterDTO> filterDTOList,@SortDefault(sort = "id", direction = Sort.Direction.DESC)  @PageableDefault(page = 0, size = 10) Pageable pageable) throws postNotFoundException{
        Page<Post> posts = postservicio.searchByFilter(filterDTOList,pageable);
        if(!posts.isEmpty()){
            return ResponseEntity.ok(posts);
        }else{
            throw new postNotFoundException("There isn't a post with the indicate values");
        }
    }

    @GetMapping("/findById/{id}")//*
    public ResponseEntity<Post> getById(@PathVariable("id") Long id) throws postNotFoundException {
        return ResponseEntity.ok(postservicio.findById(id));
    }

    @Override
    @PutMapping("/actualizarAll/{id}")
    public ResponseEntity<Post> putById(@PathVariable("id") Long id, @Valid @RequestBody Post post) throws postNotFoundException, MethodArgumentNotValidException {
        return ResponseEntity.ok(postservicio.putById(id,post));
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id) throws postNotFoundException {
        return ResponseEntity.ok(postservicio.deleteById(id));
    }

    @Override
    @PatchMapping("/actualizarCampos/{id}")
    public ResponseEntity<Post> patchPost(@PathVariable Long id, @Valid @RequestBody Post fields) throws postNotFoundException, MethodArgumentNotValidException, IllegalAccessException {
        return ResponseEntity.ok(postservicio.patchById(id, fields));
    }



    @Override
    @PostMapping("/create") //*
    public ResponseEntity<Post> createPost( @Valid @RequestBody Post post) throws entityCreationException, MethodArgumentNotValidException{
        return ResponseEntity.ok(postservicio.crearPost(post));

    }

    @GetMapping("/getall")
    public ResponseEntity<Page<Post>> getAll(@SortDefault(sort = "id", direction = Sort.Direction.DESC)  @PageableDefault(page = 0, size = 10) Pageable pageable)  {
            return ResponseEntity.ok(postservicio.getAll(pageable));
    }











}
