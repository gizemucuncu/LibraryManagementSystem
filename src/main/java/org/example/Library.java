package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }


    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitap Kütüphane Yönetim Sistemine başarıyla eklendi, teşekkürler.");
    }

    public void searchBook(String searchBook) {

        // Girilen değerin listedeki herhangi bir kitap ismi ile eşleşmemesi durumu için boolean found değişkeni tanımlandı
        boolean found = false;

        for (Book book : books) {
            String bookName = book.getBookName();

            // Girilen değer, kitap isminin tamamıyla eşleşiyor mu kontrol edilir
            if (bookName.equalsIgnoreCase(searchBook)) {
                System.out.println("'" + searchBook + "'" + " aramasına göre sonuçlar: \n" + book);
                found = true;
                continue;
            }

            // Girilen kelime/kelime grubu kitap isminde geçiyor mu kontrol edilir
            if (bookName.toLowerCase().contains(searchBook.toLowerCase())) {
                System.out.println("'" + searchBook + "'" + " aramasına göre sonuçlar: \n" + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aradığınız kitap bulunamadı: '" + searchBook + "'");
        }
    }


    public void borrowBook(int isbnToBorrow) {

        // Girilen değerin listedeki herhangi bir ISBN ile eşleşmemesi durumu için boolean found değişkeni tanımlandı
        boolean found = false;

        for (Book book : books) {
            //Kitabın ISBN numarası, kullanıcının girdiği ISBN numarasına eşit mi kontrolü yapılır.
            if (book.getIsbn() == isbnToBorrow) {
                found = true;

                // kitap ödünç alınmamışsa ödünç alım işlemi yapılır. İlgili kitabın state'i false'dan true'ya çekilir.
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("ISBN: " + isbnToBorrow + " numaralı kitabı aldınız");

                } else {
                    //Kitap ödünç alınmışsa, işlem tekrar yapılamaz hata mesajı yazdırılır.
                    System.out.println("ISBN: " + isbnToBorrow + " numaralı kitap zaten ödünç alınmış");
                }

                break;
            }
        }

        if (!found) {
            System.out.println("Girilen ISBN: " + isbnToBorrow + " numarasıyla eşleşen kitap bulunamadı");
        }
    }

    public void returnBook(int returnBookWithISBN) {

        // Girilen değerin listedeki herhangi bir ISBN ile eşleşmemesi durumu için boolean found değişkeni tanımlandı.
        boolean found = false;

        for (Book book : books) {
            if (book.getIsbn() == returnBookWithISBN) {
                found = true;

                // kitap ödünç alınmışsa, iade işlemi yapılır. ilgili kitabın state'i true'dan false'a çekilir.
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("ISBN: " + returnBookWithISBN + " numaralı kitabını iade ettiğiniz için teşekkürler.");

                } else {
                    // kitap zaten kütüphanede mevcut ise hata mesajı yazdırılır.
                    System.out.println("Hatalı işlem yaptınız.\nISBN: " + returnBookWithISBN + " numaralı kitap zaten kütüphanede mevcut.");
                }

                break;
            }
        }

        if (!found) {
            System.out.println("Girilen ISBN: " + returnBookWithISBN + " numarasıyla eşleşen kitap bulunamadı");
        }
    }
}
