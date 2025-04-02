package org.example;

public class Book {
    private String bookName;  // Kitap ismi
    private boolean isBorrowed;  // Ödünç alınıp alınmadığı bilgisi
    private String author; // Kitabın yazarı
    private int isbn; // Kitabın ISBN numarası

    public Book() {

    }

    public Book(String title, String author, int isbn, boolean status) {
        this.bookName = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "-----------------------------------------------\n" +
                "Title: " + bookName + '\n' +
                "Author: " + author + '\n' +
                "ISBN: " + isbn + '\n' +
                "Status: " + (isBorrowed ? "Ödünç Alınmış" : "Mevcut") + '\n' +
                "-----------------------------------------------";
    }
}
