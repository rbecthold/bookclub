package com.bookclub.service.impl;

import com.bookclub.service.dao.BookDao;
import com.bookclub.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemBookDao implements BookDao {
    private List<Book> books = new ArrayList<>();

    public MemBookDao() {
        this.books.add(new Book("978-0142437964", "In Search of Lost Time", "A book about a swan.", 468, List.of("Marcel Proust")));
        this.books.add(new Book("978-1840226355", "Ulysses", "A story about an American General", 736, List.of("James Joyce")));
        this.books.add(new Book("978-0142437230", "Don Quixote", "Who is this man with Sancho Panza?", 1072, List.of("Miguel De Cervantes Saavedra")));
        this.books.add(new Book("978-0061120091", "One Hundred Years of Solitude", "Wow, that sounds like a long time.", 417, List.of("Gabriel Garcia Marquez")));
        this.books.add(new Book("978-0743273565", "The Great Gatsby", "This one's about rich love.", 180, List.of("F. Scott Fitzgerald")));
    }

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        for(Book book : this.books) {
            if(book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}
