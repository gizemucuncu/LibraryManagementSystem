# Kütüphane Yönetim Sistemi (Library Management System)

## Açıklama

Bu proje, kütüphane yönetim sistemi uygulamasıdır. Kullanıcılar kitap ekleyebilir, kitap ödünç alabilir, ödünç aldıkları kitapları iade edebilir, kütüphanedeki mevcut kitapları listeleyebilir ve kitap araması yapabilirler.

## Özellikler

__Kitap ekleme__: Kütüphaneye yeni kitap eklenebilir.

__Kitap ödünç alma__: Kullanıcılar mevcut kitapları ödünç alabilir.

__Kitap iade etme__: Kullanıcılar ödünç aldıkları kitapları geri verebilir.

__Kitap listeleme__: Kütüphanede bulunan tüm kitaplar görüntülenebilir.

__Kitap arama__: Kitap adıyla arama yapılabilir.

## Kullanım Kılavuzu

Program çalıştırıldığında aşağıdaki menü görüntülenir:

1- Kitap Ekleme

2- Kitap Ödünç Al

3- Kitap İade

4- Kitap Listeleme

5- Kitap Arama

6- Çıkış

Kitap eklemek için __1__ seçeneğini girin ve kitap bilgilerini girin.

Kitap ödünç almak için __2__ seçeneğini girin ve ISBN numarasını yazın.

Kitap iade etmek için __3__ seçeneğini girin ve ISBN numarasını yazın.

Mevcut kitapları listelemek için __4__ seçeneğini girin.

Belirli bir kitabı aramak için __5__ seçeneğini girin ve kitabın adını yazın.

Çıkış yapmak için __6__ seçeneğini girin.

## Proje Dosya Yapısı

- `src/`
  - `org.example/`
    - `LibraryManagementSystem.java` - Ana sınıf, kullanıcı menüsünü yönetir
    - `Book.java` - Kitap model sınıfı, kitap bilgilerini içerir
    - `Library.java` - Kütüphane yönetimi, kitap ekleme, arama ve ödünç alma vb. işlemlerini içerir
