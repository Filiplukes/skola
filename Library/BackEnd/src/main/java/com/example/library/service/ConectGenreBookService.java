package com.example.library.service;

import com.example.library.model.ConectGenreBook;
import com.example.library.repository.ConectGenreRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConectGenreBookService {
    @Resource
    ConectGenreRepository conectGenreRepository;

    public List<ConectGenreBook> getAllConectGenre() {
        return conectGenreRepository.findAll();
    }

    public ConectGenreBook getConectGenre(Long id) {
        return conectGenreRepository.getReferenceById(id);
    }

    public void createConectGenre(ConectGenreBook ConectGenreBook){

        conectGenreRepository.save(ConectGenreBook);
    }

}