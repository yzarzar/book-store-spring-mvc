package com.example.bookstoremvc;

import com.example.bookstoremvc.dao.AuthorDao;
import com.example.bookstoremvc.dao.BookDao;
import com.example.bookstoremvc.dao.CategoryDao;
import com.example.bookstoremvc.entity.Author;
import com.example.bookstoremvc.entity.Book;
import com.example.bookstoremvc.entity.BookStatus;
import com.example.bookstoremvc.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class BookStoreMvcApplication {
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;
    private final BookDao bookDao;

    @Bean @Transactional
    public ApplicationRunner runner(){
        return r ->{
            //for bestSellers
            Category category = new Category();
            category.setCategoryName("Programming");

            Author author1 = new Author("Robert.C", "Martin", "martin@gmail.com",
                    LocalDate.of(1952, 12, 5),
                    "\"Uncle Bob\" is a nickname for Robert C. Martin,+" +
                            " a well-known figure in the software development industry. +" +
                            "He is a software engineer and author who has made significant +" +
                            "contributions to the field of software development and agile methodologies.",
                    "uncle_bob");

            Book book1 = new Book("Clean Code", 40.5, LocalDate.of(2008, 3, 11),
                    "Pearson", BookStatus.BESTSELLER, "clean_code");

            Category category2 = new Category();
            category2.setCategoryName("Science");


            Author author2 = new Author("Stephen", "Howking", "stephen@gmail.com",
                    LocalDate.of(1942, 1, 8),
                    "He was a renowned theoretical physicist and cosmologist who made significant contributions to the study of black holes and the Big Bang." +
                            " He was also a best-selling author, with his most famous book being A Brief History of Time.",
                    "hawking");
            Book book2 = new Book("A Brief History Of Time",
                    18.99, LocalDate.of(1988, 1, 1),
                    "Bantam Dell", BookStatus.BESTSELLER, "history_of_time");

            Category category3 = new Category();
            category3.setCategoryName("Programming");

            Author author3 = new Author("Joshua", "Bloch", "bloch@gmail.com",
                    LocalDate.of(1961, 8 , 28),
                    "Joshua J. Bloch (born August 28, 1961) is an American software engineer and a technology author, " +
                            "formerly employed at Sun Microsystems and Google." +
                            " He led the design and implementation of numerous Java platform features, including the Java Collections Framework," +
                            " the java.math package, and the assert mechanism",
                    "bloch");

            Book book3 = new Book("Effective Java", 55.2, LocalDate.of(2017 , 12, 27),
                    "Addison-Wesley", BookStatus.BESTSELLER, "effective_java" );

            Category category4 = new Category();
            category4.setCategoryName("Novel");

            Author author4 = new Author("Thomas", "Hardy", "thomas@gmail.com",
                    LocalDate.of(1840, 06, 02),
                    "Thomas Hardy was an English novelist and poet born on June 2, 1840, in Higher Bockhampton, Dorset, England, and he passed away on January 11, 1928, in Dorchester, Dorset. " +
                            "He is known for his significant contributions to English literature during the Victorian and early 20th-century periods.",
                    "hardy");

            Book book4 = new Book("Far From The", 32.5, LocalDate.of(1874, 1, 12),
                    "Collins", BookStatus.BESTSELLER, "far");

            Author author5 = new Author("Yasunari", "Kawabata", "yasunari@gmail.com", LocalDate.of(1899, 6, 11),
                    "Yasunari Kawabata (川端 康成) was a renowned Japanese novelist and short story writer. " +
                            "He was born on June 11, 1899, in Osaka, Japan, and he passed away on April 16, 1972, in Zushi, Japan." +
                            " Kawabata is considered one of Japan's most distinguished literary figures and is particularly known for his elegant and lyrical prose style.",
                    "kawabata");

            Book book5 = new Book("Snow Country", 20.5, LocalDate.of(1948, 1, 1),
                    "Pole Star", BookStatus.BESTSELLER, "snow");

            Author author6 = new Author("Charles", "Dickens", "charles@gmail.com",
                    LocalDate.of(1812, 2,7),
                    "Charles Dickens (1812-1870) was a renowned English novelist and social critic of the Victorian era." +
                            " He is widely regarded as one of the greatest novelists in the English language and is known for his vivid characters, intricate plots, and social commentary.",
            "charles");

            Author author7 = new Author("Jane", "Austen", "austen@gmail.com",
                    LocalDate.of(1775, 12, 16),
                    ". She is one of the most celebrated and widely read authors in English literature." +
                            " Her works primarily focus on the lives and marriages of the English" +
                            " upper-middle class during the late 18th and early 19th centuries.",
                    "jane");
            Author author8 = new Author("Emily","Dickinson","emily@gmail.com",
                    LocalDate.of(1830,12,10),
                    "Emily Dickinson was an American poet known for her" +
                            " distinctive and innovative style of writing. " +
                            "She was born on December 10, 1830, in Amherst, " +
                            "Massachusetts, and she died there on May 15, 1886." +
                            " Dickinson is widely regarded as one of the most important" +
                            " and influential poets in American literature, despite only " +
                            "a small fraction of her work being published during her lifetime. " +
                            "Here is a brief biography of Emily Dickinson:","emily");

            Author author9 = new Author("Earnest","Hemingway", "earnest@gmail.com",
                    LocalDate.of(1899,7,21),
                    "Ernest Hemingway was an iconic American" +
                            " novelist and short story writer known for" +
                            " his distinctive writing style and his adventuresome life. " +
                            "Here is a brief biography of Ernest Hemingway:","earnest");

            Book book6 = new Book("David Copperfield", 35.3, LocalDate.of(1850,1,1),
                    "Amazon", BookStatus.RECOMMENDED,
                    "david");

            Book book7 = new Book("Great Expectations", 40.3,
                    LocalDate.of(1861, 1,1),
                    "Amazon",
                    BookStatus.RECOMMENDED,"great");

            Book book8 = new Book("Oliver Twist", 33.5,
                    LocalDate.of(1838, 1,1),
                    "Sun", BookStatus.RECOMMENDED,
                    "oliver");

            Book book9 = new Book("Pride and Prejudice",30.5,
                    LocalDate.of(2008,5,16),
                    "Amazon",BookStatus.RECOMMENDED,
                    "pride");

            Book book10 = new Book("Emma", 40.5, LocalDate.of(2003,5,6),
                    "Amazon",BookStatus.RECOMMENDED,
                    "emma");

            Book book11 = new Book("Fellowship Point",23.5,
                    LocalDate.of(2003,2,3),
                    "David",BookStatus.NEW,"point");

            Book book12 = new Book("The Adventures of Tom Sawyer ",95.0,
                    LocalDate.of(1876,3,4),
                    "Amazon",BookStatus.NEW,"sawyer");

            Book book13 = new Book("The Prince and the Pauper",23.4,
                    LocalDate.of(1881,2,11),
                    "Alibaba",BookStatus.NEW,"pauper");

            Book book14 = new Book("The Old Man and the Sea ",23.4,
                    LocalDate.of(1952,1,2),
                    "film",BookStatus.NEW,"sea");

            Book book15 = new Book("A Farewell to Arms ",55.6,
            LocalDate.of(1992,3,4),
                    "American",BookStatus.NEW,"war");

            category.addBook(book1);
            author1.addBook(book1);

            category2.addBook(book2);
            author2.addBook(book2);

            category3.addBook(book3);
            author3.addBook(book3);

            category4.addBook(book4);
            author4.addBook(book4);

            category4.addBook(book5);
            author5.addBook(book5);

            category4.addBook(book6);
            category4.addBook(book7);
            category4.addBook(book8);
            category4.addBook(book9);
            category4.addBook(book10);
            category4.addBook(book12);
            category4.addBook(book13);
            category4.addBook(book14);
            category4.addBook(book15);
            author6.addBook(book6);
            author6.addBook(book7);
            author6.addBook(book8);
            author7.addBook(book9);
            author7.addBook(book10);
            author8.addBook(book11);
            author8.addBook(book12);
            author9.addBook(book13);
            author9.addBook(book14);
            author9.addBook(book15);

            categoryDao.save(category);
            categoryDao.save(category2);
            categoryDao.save(category3);
            categoryDao.save(category4);

            authorDao.save(author1);
            authorDao.save(author2);
            authorDao.save(author3);
            authorDao.save(author4);
            authorDao.save(author5);
            authorDao.save(author6);
            authorDao.save(author7);
            authorDao.save(author8);
            authorDao.save(author9);

            bookDao.save(book1);
            bookDao.save(book2);
            bookDao.save(book3);
            bookDao.save(book4);
            bookDao.save(book5);
            bookDao.save(book6);
            bookDao.save(book7);
            bookDao.save(book8);
            bookDao.save(book9);
            bookDao.save(book10);
            bookDao.save(book11);
            bookDao.save(book12);
            bookDao.save(book13);
            bookDao.save(book14);
            bookDao.save(book15);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreMvcApplication.class, args);
    }

}
