package com.santosh.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.springjpa.model.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {

}
