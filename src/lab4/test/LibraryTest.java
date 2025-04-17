package lab4.test;

import lab4.book.Book;
import lab4.library.Library;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Война и мир", "Лев Толстой", 1869);
        Book book2 = new Book("Анна Каренина", "Лев Толстой", 1877);
        Book book3 = new Book("Преступление и наказание", "Фёдор Достоевский", 1866);
        Book book4 = new Book("1984", "Джордж Оруэлл", 1949);
        Book book5 = new Book("Скотный двор", "Джордж Оруэлл", 1945);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        System.out.println("=== Тестирование библиотеки ===");
        library.printAllBooks();
        System.out.println();

        library.printUniqueAuthors();
        System.out.println();

        library.printAuthorStatistics();
        System.out.println();

        System.out.println("Книги Льва Толстого:");
        library.findBooksByAuthor("Лев Толстой").forEach(System.out::println);
        System.out.println();

        System.out.println("Книги 1949 года:");
        library.findBooksByYear(1949).forEach(System.out::println);
        System.out.println();

        System.out.println("Удаляем книгу: " + book3);
        library.removeBook(book3);
        library.printAllBooks();
        library.printAuthorStatistics();
    }
}