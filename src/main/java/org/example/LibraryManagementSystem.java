package org.example;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        System.out.println("<< Kütüphane yönetim sistemine hoş geldiniz >>");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Library library;
        library = new Library();
        List<Book> books = library.getBooks();

        while (running) {
            // Menüye göre kullanıcıdan yapmak istediği işlem için input alınır
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Kullanıcıdan alınan inputa göre yapılmak istenen işlemler switch-case yapısında gerçekleştirilir
            switch (choice) {
                case 1:
                    addBook(scanner, library);
                    break;

                case 2:
                    borrowBook(library, scanner);
                    break;

                case 3:
                    returnBook(scanner, library);
                    break;

                case 4:
                    listBook(library);
                    break;

                case 5:
                    searchBook(scanner, library);
                    break;

                case 6:
                    System.out.println("Kütüphane yönetim sistemini kullandığınız için teşekkürler...");
                    running = false;
                    break;

                default:
                    System.out.println("Hatalı giriş yapıldı...");

            }
        }
    }

    private static void addBook(Scanner scanner, Library library) {

        System.out.println("Kütüphaneye eklemek istediğiniz kitabın adını giriniz: ");
        String title = scanner.nextLine();

        System.out.println("Kütüphaneye eklemek istediğiniz kitabın yazar bilgisini giriniz: ");
        String author = scanner.nextLine();

        System.out.println("Kütüphaneye eklemek istediğiniz kitabın ISBN bilgisini giriniz: ");
        int isbn = scanner.nextInt();

        // Kullanıcıdan alınan kitap bilgileri addBook fonskiyonuna gönderilir ve ekleme işlemi burada yapılır.
        Book addedBook = new Book(title, author, isbn, false);
        library.addBook(addedBook);
    }

    private static void listBook(Library library) {

        // Sistemde listelenecek kitap bulunup bulunmadığı kontrol edilip, buna göre kitap listesi veya mesaj döndürülür.
        if (library.getBooks().isEmpty()) {
            System.out.println("Kütüphanede kayıtlı kitap bulunmamaktadır.");

        } else {
            System.out.println("Kütüphane sisteminde kayıtlı kitaplar: ");

            for (Book book : library.getBooks()) {
                System.out.println(book);
            }
        }
    }

    private static void borrowBook(Library library, Scanner scanner) {

        // Sistemde kayıtlı kitap var mı yok mu kontrolü yapılır, varsa kitaplar listelenir
        if (!library.getBooks().isEmpty()) {
            System.out.println("Alabileceğiniz kitaplar: ");

            for (Book book : library.getBooks()) {
                System.out.println(book);
            }

            // Listelenen kitaplara göre kullanıcıdan ISBN numarası girdisi istenir.
            // Kullanıcıdan ödünç almak istediği kitap için input alınır ve borrowBook fonskiyonuna gönderilir, işlem burada devam eder.
            System.out.println("Almak istediğiniz kitabın ISBN numarasını girin: ");
            int isbnToBorrow = scanner.nextInt();
            library.borrowBook(isbnToBorrow);

        } else {
            // Sistemde kitap yoksa hata mesajı yazdırılır.
            System.out.println("Kütüphane sisteminde kayıtlı kitap bulunmamaktadır.");
        }
    }

    private static void returnBook(Scanner scanner, Library library) {

        // Listenin boş olup olmadığı kontrol edilir
        if (!library.getBooks().isEmpty()) {

            for (Book book : library.getBooks()) {
                System.out.println(book);
            }

            // Listelenen kitaplara göre kullanıcıdan ISBN numarası girdisi istenir.
            // Kullanıcıdan iade etmek istediği kitap için input alınır ve returnBook fonskiyonuna gönderilir, işlem burada devam eder.
            System.out.println("Listeye göre teslim etmek istediğiniz kitabın ISBN numarasını giriniz");
            int returnBookISBN = scanner.nextInt();
            library.returnBook(returnBookISBN);

        } else {
            // liste boşsa hata mesajı yazdırılır
            System.out.println("Kütüphane sisteminde kayıtlı kitap bulunmamaktadır.");
        }
    }

    private static void searchBook(Scanner scanner, Library library) {

        // Kullanıcıdan arama yapmak için input alınır ve saerchBook fonskiyonuna gönderilir, işlem burada devam eder.
        if (!library.getBooks().isEmpty()) {
            System.out.println("Aramak istediğiniz kitabın ismini giriniz");
            String searchBook = scanner.nextLine();
            library.searchBook(searchBook);

        } else {
            System.out.println("Kütüphane sisteminde arama yapabileceğiniz kayıtlı kitap bulunmamaktadır");
        }
    }

    public static void printMenu() {
        System.out.println("\nYapmak istediğiniz işlemi seçin:");
        System.out.println("1- Kitap Ekleme");
        System.out.println("2- Kitap Ödünç Al");
        System.out.println("3- Kitap İade");
        System.out.println("4- Kitap Listeleme");
        System.out.println("5- Kitap Arama");
        System.out.println("6- Çıkış");
    }
}