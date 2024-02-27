package com.c1646njava.tuvivienda.services.implementation;

import com.c1646njava.tuvivienda.exeptions.dto.Patcher.Patcher;
import com.c1646njava.tuvivienda.exeptions.PostExceptions.entityCreationException;
import com.c1646njava.tuvivienda.exeptions.PostExceptions.postNotFoundException;
import com.c1646njava.tuvivienda.models.post.DTO.FilterDTO;
import com.c1646njava.tuvivienda.models.post.DTO.PostSpecification;
import com.c1646njava.tuvivienda.models.post.Post;
import com.c1646njava.tuvivienda.repositories.PostRepository;
import com.c1646njava.tuvivienda.services.abstraction.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.BeanUtils;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class PostServiceI implements PostService {


    private  PostRepository postrepositorio;
    private Patcher patcher;

    public PostServiceI(PostRepository postrepositorio, Patcher patcher) {
        this.postrepositorio = postrepositorio;
        this.patcher = patcher;
    }


    public Page<Post> searchByFilter(List<FilterDTO> filterDtoList, Pageable pageable){
        return postrepositorio.findAll(PostSpecification.columnEqual(filterDtoList),pageable);

    }

    public Post crearPost(Post post) throws entityCreationException{
        postrepositorio.save(post);
        Optional<Post> posteo = postrepositorio.findById(post.getId());

        if(posteo.isPresent()){
            return posteo.get();
        }else{
            throw new entityCreationException("the entity was not persisted correctly");
        }
    }

    @Override
    public Post findById(Long id) throws postNotFoundException {
        Optional<Post> posteo = postrepositorio.findById(id);
        if(posteo.isPresent()){
            return posteo.get();
        }else{
            throw new postNotFoundException("there isn't a post with the id: " + id);
        }
    }

    @Override
    public String deleteById(Long id) throws postNotFoundException {
        Optional<Post> posteo = postrepositorio.findById(id);
        if(posteo.isPresent()){
            postrepositorio.deleteById(id);
            return "Post eliminado";
        }else{
            throw new postNotFoundException("there isn't a post with the id: " + id);
        }

    }

    @Override
    public Post putById(Long id, Post post) throws postNotFoundException {
        Optional<Post> posteo = postrepositorio.findById(id);
        if(posteo.isPresent()){
            Post postinner = posteo.get();
            BeanUtils.copyProperties(post,postinner, "id");
            postrepositorio.save(post);
            return post;
        }else{
            throw new postNotFoundException("there isn't a post with the id: " + id);
        }
    }

    @Override
    public Post patchById(Long id,  Post fields) throws postNotFoundException, IllegalAccessException {
        Optional<Post> posteoOptional = postrepositorio.findById(id);

        if(posteoOptional.isPresent()){
            try {
                Post postExistente = posteoOptional.get();
                Patcher.postPatcher(postExistente, fields);
                postrepositorio.save(postExistente);
                return postExistente;
            }catch(IllegalAccessException e){
                throw new IllegalAccessException("Issue trying to execute reflexivity in Post class");
            }
        }else{
            throw new postNotFoundException("there isn't a post with the id: " + id);

        }
    }

    @Override
    public Page<Post> getAll( Pageable pageable){
        return postrepositorio.findAll(pageable);
    }











}
