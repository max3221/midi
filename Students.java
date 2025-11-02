package aston;
import java.util.*;


class Book {
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }


    public String toString() {
        return title + " (" + pages + " стр., " + year + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return pages == book.pages && year == book.year && title.equals(book.title);
    }

    public int hashCode() {
        return Objects.hash(title, pages, year);
    }
}

class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String toString() {
        return "Студент " + name + ": " + books;
    }
}


public class Students {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Иван", List.of(
                        new Book("Книга A", 300, 1999),
                        new Book("Книга B", 150, 2005),
                        new Book("Книга C", 200, 2010),
                        new Book("Книга D", 400, 2001),
                        new Book("Книга E", 120, 1995)
                )),
                new Student("Мария", List.of(
                        new Book("Книга F", 180, 2003),
                        new Book("Книга G", 220, 2008),
                        new Book("Книга H", 330, 2012),
                        new Book("Книга I", 150, 1998),
                        new Book("Книга J", 210, 2005)
                )),
                new Student("Пётр", List.of(
                        new Book("Книга K", 290, 2000),
                        new Book("Книга L", 310, 2015),
                        new Book("Книга M", 400, 2020),
                        new Book("Книга N", 100, 2004),
                        new Book("Книга O", 220, 2006)
                ))
        );

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}
