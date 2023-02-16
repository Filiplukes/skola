package com.example.library.repository;

import com.example.library.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

   List<BookModel> findByUserId(Long userId);

   @Query("SELECT b, array_agg(g.genreName) as genres " +
           "FROM BookModel b " +
           "LEFT JOIN ConectGenreBook cgb ON b.id = cgb.idBook " +
           "LEFT JOIN Genre g ON cgb.idGenre = g.id " +
           "WHERE b.userId = :userId " +
           "GROUP BY b.id")
   List<Object[]> findByUserIdWithGenres(@Param("userId") Long userId);



   @Query("SELECT b, array_agg(g.genreName) as genres " +
           "FROM BookModel b " +
           "LEFT JOIN ConectGenreBook cgb ON b.id = cgb.idBook " +
           "LEFT JOIN Genre g ON cgb.idGenre = g.id " +
           "GROUP BY b.id")
   List<Object[]> findAllBooksWithGenres();



   @Query("SELECT b, array_agg(g.genreName) as genres " +
           "FROM BookModel b " +
           "LEFT JOIN ConectGenreBook cgb ON b.id = cgb.idBook " +
           "LEFT JOIN Genre g ON cgb.idGenre = g.id " +
           "WHERE b.author = :author AND b.userId IS NULL " +
           "GROUP BY b.id " +
           "ORDER BY random() " +
           "LIMIT 1")
   Object findRandomBookByAuthor(@Param("author") String author);

}



