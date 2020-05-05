package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService<SchoolBook> {
    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    @Override
    public boolean save(SchoolBook book) {

       if(authorService.findByFullName(book.getAuthorName(), book.getAuthorLastName())==null){
           return false;
       } else {
           return schoolBookBookRepository.save(book);
       }
    }

    @Override
    public SchoolBook[] findByName(String name) {
        return schoolBookBookRepository.findByName(name);
    }

    @Override
    public int getNumberOfBooksByName(String name) {
        SchoolBook[] allBooks = schoolBookBookRepository.findByName(name);
        return allBooks.length;
    }

    @Override
    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    @Override
    public int count() {
        return schoolBookBookRepository.count();
    }


    @Override
    public Author findAuthorByBookName(String name) {
        SchoolBook[] books = schoolBookBookRepository.findByName(name);
        if(books.length==0){
            return null;
        } else{
            return authorService.findByFullName(books[0].getAuthorName(),books[0].getAuthorLastName());
        }
    }
}