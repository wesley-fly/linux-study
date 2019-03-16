package com.lee.server.sessionbean;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lixiaofan0122@gmail.com
 * Date: 3/7/19
 * Time: 1:49 PM
 */
@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {
    List<String> savedBooks;

    public LibrarySessionBean() {
        savedBooks = new ArrayList<String>();
    }

    @Override
    public void addBook(String bookName) {
        savedBooks.add(bookName);
    }

    @Override
    public List<String> getBooks() {
        return savedBooks;
    }
}
