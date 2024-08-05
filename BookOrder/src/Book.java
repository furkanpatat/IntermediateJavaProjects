public class Book implements Comparable<Book> {
    private String bookName;
    private int pageNumber;
    private String author;
    private String date;

    public Book(String bookName, int pageNumber, String author, String date) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.author = author;
        this.date = date;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Book that) {
            return this.getBookName().compareTo(that.getBookName());
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", pageNumber=" + pageNumber +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
