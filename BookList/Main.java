import java.util.*;
import java.util.stream.Collectors;

@FunctionalInterface
interface IFilter{
    List<Book> filter();
}
@FunctionalInterface
interface IPrint{
    void print();
}

class Book{
    private String bookName;
    private int numberOfPages;
    private String author;
    private String publicationDate;

    public Book(String bookName, int numberOfPages, String author, String publicationDate) {
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}


public class Main {
    public static void main(String[] args) {
        Book animalFarm = new Book("Animal Farm",144,"George Orwell","1945");
        Book dune = new Book("Dune",712,"Frank Herbert","1965");
        Book martinEden = new Book("Martin Eden",520,"Jack London","1909");
        Book wertherPain = new Book("The Sorrows of Young Werther",164,"Goethe","1774");
        Book amok = new Book("Amok",64,"Stefan Zweig","1922");
        Book chess = new Book("Chess",71,"Stefan Zweig","1942");
        Book crimeAndPunishment = new Book("Crime And Punishment",501,"Dostoyevski","1866");
        Book oliverTwist = new Book("Oliver Twist",576,"Charles Dickens","1838");
        Book Iliad = new Book("Iliad",71,"Homeros","7th - 8th century");
        Book metamorphosis = new Book("The Metamorphosis",63,"Kafka","1915");

        List<Book> bookList = new ArrayList<>(Arrays.asList(animalFarm,dune,martinEden,wertherPain,amok,chess,crimeAndPunishment,oliverTwist,Iliad,metamorphosis));

        Map<String,String> bookMap =  bookList.stream().collect(Collectors.toMap(Book::getBookName,Book::getAuthor));

        IFilter filter = () -> bookList.stream().filter(p-> p.getNumberOfPages()>100).collect(Collectors.toList());

        IPrint print = () -> bookMap.forEach((bookname,author)-> System.out.println(bookname+"->"+author));

        System.out.println("------------------ALL BOOKS WITH INFO------------------");
        bookList.stream().forEach(book -> System.out.println("Book->\t"+book.getBookName()+"\tAuthor->\t"+book.getAuthor()+"\tPage->\t"+book.getNumberOfPages()+"\tDate->\t"+book.getPublicationDate()));
        System.out.println();
        System.out.println("------------------ALL BOOKS WITH AUTHOR------------------");
        print.print();
        System.out.println();
        System.out.println("------------------BOOKS WITH MORE THAN 100 PAGES------------------");
        List<Book> list = filter.filter();
        list.stream().forEach(p -> System.out.println(p.getBookName() + " -> "+p.getNumberOfPages()));

    }
}