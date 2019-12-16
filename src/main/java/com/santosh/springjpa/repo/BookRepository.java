package com.santosh.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santosh.springjpa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByName(String name);

	@Query("SELECT t FROM Book t WHERE t.name = :name")
	Book findBookByName(@Param("name") String name);

	@Query("SELECT t FROM Book t")
	List<Book> findAllBooks();

	@Query("SELECT b from Book b join b.bookCategory bc where bc.id = :bookCategoryId")
	List<Book> getBooksByCategoryId(@Param("bookCategoryId") Integer categoryId);
}
