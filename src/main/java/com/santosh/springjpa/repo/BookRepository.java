package com.santosh.springjpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santosh.springjpa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Optional<Book> findById(Integer id);

	@Query("SELECT t FROM Book t WHERE t.name like %:name%")
	List<Book> findBooksByName(@Param("name") String name);

	@Query("SELECT t FROM Book t")
	List<Book> findAllBooks();

	@Query("select t from Book t whete t.id = ?1")
	List<Book> findBookById(Integer id);

	@Query("SELECT b from Book b join b.bookCategory bc where bc.id = :bookCategoryId")
	List<Book> getBooksByCategoryId(@Param("bookCategoryId") Integer categoryId);
}
