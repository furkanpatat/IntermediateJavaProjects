import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*Book Sorter

Design a class named Book. Inherit this class from the Comparable interface and override the "compareTo" method.
In this method, write the code that sorts the book by name from A to Z. Create 5 objects from this class and store the objects in a Set type structure.
Then, for the second time, use a data structure of type Set and arrange the books according to the number of pages.
The Book class consists of book name, number of pages, author's name, and publication date variables.*/


public class Main {
    public static void main(String[] args) {
        HashSet<Book> hashSet = new HashSet<>();
        HashSet<Book> hashSet1 = new HashSet<>();

        //1. HashSet
        hashSet.add(new Book("Kürk Mantolu Madonna",177,"Sabahattin Ali","1943"));
        hashSet.add(new Book("Beyaz Diş",256,"Jack London","1906"));
        hashSet.add(new Book("Satranç",192,"Stefan Zweig","1942"));
        hashSet.add(new Book("Don Kişot",292,"Miguel de Cervantes","1605"));
        hashSet.add(new Book("Anna Karenina",864,"Lev Tolstoy","1873"));

        //2.HashSet
        hashSet1.add(new Book("Kürk Mantolu Madonna",177,"Sabahattin Ali","1943"));
        hashSet1.add(new Book("Beyaz Diş",256,"Jack London","1906"));
        hashSet1.add(new Book("Satranç",192,"Stefan Zweig","1942"));
        hashSet1.add(new Book("Don Kişot",292,"Miguel de Cervantes","1605"));
        hashSet1.add(new Book("Anna Karenina",864,"Lev Tolstoy","1873"));

        //To use the collection.sort() method, we turn it into an arraylist.
        List<Book> bookList = new ArrayList<>(hashSet);
        List<Book> bookList1 = new ArrayList<>(hashSet1);

        // Before name order
        for (Book book:bookList) {
            System.out.println(book);
        }


        Collections.sort(bookList);
        System.out.println("----------------------------------------------------");

        //After name order
        for (Book book:bookList) {
            System.out.println(book);
        }
        System.out.println();

        //before sorting by page count
        for (Book book:bookList1) {
            System.out.println(book);
        }


        OrderByPageNumber orderByPageNumber = new OrderByPageNumber();
        bookList1.sort(orderByPageNumber);

        System.out.println("----------------------------------------------------");

        //after sorting by page count
        for (Book book:bookList1) {
            System.out.println(book);
        }


    }

}
