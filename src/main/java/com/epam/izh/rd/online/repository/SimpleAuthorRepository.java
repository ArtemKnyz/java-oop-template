package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[]{};


    @Override
    public boolean save(Author author) {

        if (findByFullName(author.getName(), author.getLastName()) != null) {
            return false;
        } else {
            authors = Arrays.copyOf(authors, authors.length + 1);
            authors[authors.length - 1] = author;
            return true;
        }
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author at : authors) {
            if (name == at.getName() && lastname == at.getLastName()) {
                return at;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        Author[] authorsNew;
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            return false;
        } else {
            authorsNew = new Author[count() - 1];
            int i = 0;
            for (Author ad : authors) {
                if (ad != findByFullName(author.getName(), author.getLastName())) {
                    authorsNew[i] = ad;
                    i++;
                }
            }
        }
        authors = authorsNew;
        return true;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
