package company_questions.amazon.OOD.library;


import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// LibrarySystem
// User
// Admin


//Singleton class
public class LibrarySystem implements search{
    private String name;
    private String address;
    private List<BookItem> books;
    private List<Account> accounts;

    public List<BookItem> searchByType(BookType type){
        List<BookItem> res = new ArrayList<>();
        for(BookItem book: books){
            if(book.getType().equals(type)){
                res.add(book);
            }
        }
        return res;
    }

    public BookItem searchByBarcode(String barcode){
        for(BookItem book: books){
            if(book.getBarcode().equals(barcode)){
                return book;
            }
        }
        return null;
    }
}

interface search {
    List<BookItem> searchByType(BookType type);
    BookItem searchByBarcode(String barcode);

}

abstract class Account{
    private String name;
    private String address;
    private String username;
    private String password;
    private final int maxBookToBeBorrowed=5;
}

class Members extends Account{
    private Date membershipDate;
    private int countOfBooksBorrowed;
    private List<BookItem> borrowedBooks;

}

abstract class Book{
    private String SIBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int NoOfPages;

    public String getSIBN() {
        return SIBN;
    }

    public void setSIBN(String SIBN) {
        this.SIBN = SIBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNoOfPages() {
        return NoOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        NoOfPages = noOfPages;
    }
}

class BookItem extends Book{
    private String barcode;
    private BookStatus status;
    private BookType type;
    private Date borrowedData;
    private Data dueDate;
    private double price;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public Date getBorrowedData() {
        return borrowedData;
    }

    public void setBorrowedData(Date borrowedData) {
        this.borrowedData = borrowedData;
    }

    public Data getDueDate() {
        return dueDate;
    }

    public void setDueDate(Data dueDate) {
        this.dueDate = dueDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

enum BookStatus{
    LOST,
    BORROWED,
    RESERVED,
    AVAILABLE
}

enum BookType{
    HARDCOVER,
    PAPERBACK,
    AUDIO_BOOK,
    EBOOK,
    NEWSPAPER,
    MAGAZINE,
    JOURNAL
}
