package com.bookclub.service;

import java.util.List;

public interface GenericDao<E, K> {
    List<E> list(K key); // Returns a list of objects of type E
    E find(K key); // Returns an object of type E by type K value
}
