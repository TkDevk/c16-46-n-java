package com.c1646njava.tuvivienda.services.abstraction;

import com.c1646njava.tuvivienda.exeptions.PostExceptions.entityCreationException;
import com.c1646njava.tuvivienda.exeptions.PostExceptions.postNotFoundException;
import com.c1646njava.tuvivienda.models.post.DTO.FilterDTO;
import com.c1646njava.tuvivienda.models.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface PostService {

    Page<Post> searchByFilter(List<FilterDTO> filterDtoList, Pageable pageable);

    Post crearPost(Post post) throws entityCreationException ;

    Post findById(Long id) throws postNotFoundException;


    String deleteById(Long id) throws postNotFoundException;

    Post putById(Long id, Post post) throws postNotFoundException;

    Post patchById(Long id,  Post fields) throws postNotFoundException, IllegalAccessException;

    Page<Post> getAll(Pageable pageable);

}
