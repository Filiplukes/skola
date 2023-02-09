package com.example.library.service;


import com.example.library.model.Genre;
import com.example.library.repository.GenreRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Resource
    GenreRepository genreRepository;

    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Long id) {
        return genreRepository.getReferenceById(id);
    }

    public void createGenre(Genre genre){

        genreRepository.save(genre);
    }

}
