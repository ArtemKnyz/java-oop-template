package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = {};

    public boolean save(SchoolBook book) {
        SchoolBook[] newSchoolBook = new SchoolBook[schoolBooks.length + 1];
        System.arraycopy(schoolBooks, 0, newSchoolBook, 0, schoolBooks.length);
        newSchoolBook[newSchoolBook.length - 1] = book;
        schoolBooks = newSchoolBook;
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        int value = 0;
        for (SchoolBook book : schoolBooks) {
            if (book.getName() == name) {
                ++value;
            }
        }

       SchoolBook[] bookFindByName = new SchoolBook[value];
        int i, j = 0;
        for (i = 0; i < schoolBooks.length; i++, j++) {
            if (name == schoolBooks[i].getName()) {
                bookFindByName[j] = schoolBooks[i];
            }
        }
        if (bookFindByName.length > 0) {
            return bookFindByName;
        } else {
            return new SchoolBook[0];
        }
    }

    @Override
    public boolean removeByName(String name) {
        SchoolBook[] bookTemporary;
        int countBookFindByName = 0;
        if (findByName(name) == null) {
            return false;
        } else {
            for (SchoolBook book : schoolBooks) {
                if (book.getName() == name) {
                    countBookFindByName++;
                }
            }
            bookTemporary = new SchoolBook[schoolBooks.length - countBookFindByName];
            for (int i = 0; i < schoolBooks.length; i++) {
                int j = 0;
                if (schoolBooks[i].getName() != name) {
                    bookTemporary[j] = schoolBooks[i];
                    j++;
                }
            }
            schoolBooks = bookTemporary;
            return true;
        }
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
