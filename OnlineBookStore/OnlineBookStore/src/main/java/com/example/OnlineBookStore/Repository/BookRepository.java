package com.example.OnlineBookStore.Repository;

import com.example.OnlineBookStore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorName(String authorName);
    List<Book> findByCategory(String category);
    List<Book> findByCategoryIgnoreCase(String category);
    List<Book> findByRating(double rating);
    List<Book> findByRatingGreaterThanEqual(double rating);
    List<Book> findByBookTitle(String bookTitle);
}
