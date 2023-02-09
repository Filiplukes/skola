package com.example.library.repository;

import com.example.library.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
//    List<BookModel> findByUserId(Long userId);
}
