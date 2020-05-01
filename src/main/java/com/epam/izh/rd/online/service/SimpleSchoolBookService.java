package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService {
    BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    @Override
    public boolean save(Book book) {
        schoolBookBookRepository.save((SchoolBook) book);
        return false;
    }

    @Override
    public Book[] findByName(String name) {
        schoolBookBookRepository.findByName(name);
        return new Book[0];
    }

    @Override
    public int getNumberOfBooksByName(String name) {

        return 0;
    }

    @Override
    public boolean removeByName(String name) {
        schoolBookBookRepository.removeByName(name);
        return false;
    }

    @Override
    public int count() {
        schoolBookBookRepository.count();
        return 0;
    }

    @Override
    public Author findAuthorByBookName(String name) {
        schoolBookBookRepository.findByName(name);
        return null;
    }
}
