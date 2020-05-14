package by.epam.pronovich.homework02.task04;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {
        Author pushkin = new Author("Pushkin", (short) 20);
        Author tolstoy = new Author("Tolstoy", (short) 25);
        Author dostoevskiy = new Author("Dostoevskiy", (short) 30);
        Author gogol = new Author("Gogol", (short) 35);

        Book capDoughter = new Book("Cap doughter", Arrays.asList(pushkin), 356);
        Book dubrovsiy = new Book("Dubrovsiy", Arrays.asList(pushkin), 255);
        Book poltava = new Book("Poltava", Arrays.asList(pushkin), 300);
        Book fantsy = new Book("TWO_AUTORS", Arrays.asList(pushkin, gogol), 500);
        Book voina_i_mir = new Book("Voina i mir", Arrays.asList(tolstoy), 600);
        Book anna_corenina = new Book("Anna Corenina", Arrays.asList(tolstoy), 250);
        Book idiot = new Book("Idiot", Arrays.asList(dostoevskiy), 170);
        Book shinel = new Book("Shinel", Arrays.asList(gogol), 50);

        pushkin.getBooks().add(capDoughter);
        pushkin.getBooks().add(dubrovsiy);
        pushkin.getBooks().add(poltava);
        pushkin.getBooks().add(fantsy);
        tolstoy.getBooks().add(voina_i_mir);
        tolstoy.getBooks().add(anna_corenina);
        dostoevskiy.getBooks().add(idiot);
        gogol.getBooks().add(shinel);

        Author[] authors = {pushkin, tolstoy, dostoevskiy, gogol};
        Book[] books = {capDoughter, dubrovsiy, poltava, fantsy, voina_i_mir, anna_corenina, idiot, shinel};

        List<Book> bookList = Arrays.asList(books);
        List<Author> authorList = Arrays.asList(authors);

        printBooksWithMoreThan200Pages(bookList);
        printBookWitnMaxPages(bookList);
        printBookWitnMinPages(bookList);
        printBooksWithSingleAutor(bookList);
        printSortedBooksByPages(bookList);
        printSortedBooksByTitle(bookList);
        getListOfAllTitles(bookList).forEach(System.out::println);
        getDistinctAuthors(bookList).forEach(System.out::println);
        printBiigetBookOfAuthor(authorList);


    }

    private static void printBooksWithMoreThan200Pages(List<Book> bookList) {
        bookList.stream().filter(it -> it.getNumberOfPages() > 200).map(Book::getTitle).forEach(System.out::println);
    }

    private static void printBookWitnMaxPages(List<Book> bookList) {
        Collector<Book, ?, Optional<Book>> bookMaxCollect =
                Collectors.maxBy(Comparator.comparingInt(Book::getNumberOfPages));
        bookList.stream().collect(bookMaxCollect).ifPresent(System.out::println);
    }

    private static void printBookWitnMinPages(List<Book> bookList) {
        Collector<Book, ?, Optional<Book>> bookMinCollect =
                Collectors.minBy(Comparator.comparing(Book::getNumberOfPages));
        bookList.stream().collect(bookMinCollect).ifPresent(System.out::println);
    }

    private static void printBooksWithSingleAutor(List<Book> bookList) {
        bookList.stream().filter(it -> it.getAuthors().size() == 1).map(Book::getTitle).forEach(System.out::println);
    }

    private static void printSortedBooksByPages(List<Book> bookList) {
        List<Book> sortedBooks = bookList.stream().sorted(Comparator.comparing(Book::getNumberOfPages)).
                collect(Collectors.toList());
        System.out.println();
        sortedBooks.forEach(System.out::println);

    }

    private static void printSortedBooksByTitle(List<Book> bookList) {
        List<Book> sortedBooks = bookList.stream().sorted(Comparator.comparing(Book::getTitle)).
                collect(Collectors.toList());
        System.out.println();
        sortedBooks.forEach(System.out::println);
    }

    private static List<String> getListOfAllTitles(List<Book> bookList) {
        return bookList.stream().map(Book::getTitle).collect(Collectors.toList());
    }

    private static List<Author> getDistinctAuthors(List<Book> bookList) {
        return bookList.stream().map(it -> it.getAuthors()).flatMap(it -> it.stream()).distinct()
                .collect(Collectors.toList());

    }

    private static void printBiigetBookOfAuthor(List<Author> authors) {
        authors.stream().flatMap(it -> it.getBooks().stream())
                .max(Comparator.comparing(Book::getNumberOfPages)).ifPresent(System.out::println);
    }
}
