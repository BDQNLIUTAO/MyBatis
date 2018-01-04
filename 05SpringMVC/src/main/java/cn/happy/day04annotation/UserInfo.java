package cn.happy.day04annotation;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */
public class UserInfo {
    private String name;
    //域属性
    private Book book;
    //集合
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
