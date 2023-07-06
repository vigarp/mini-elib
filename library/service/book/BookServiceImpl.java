package library.service.book;

import java.util.List;

import library.dao.BookDao;
import library.model.Book;

public class BookServiceImpl implements BookService {
    BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void createBook(Book book) {
        if (book.getTitle() == "" || book.getPublisher() == "" || book.getAuthor() == "") {
            throw new IllegalArgumentException("Title or Publisher or Author is required!");
        }
        // save ke db
        bookDao.save(book);
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = bookDao.findAll();
        if (books.size() == 0) {
            System.out.println("Book is empty");
            return null;
        } else {
            return books;
        }
    }

    @Override
    public void updateBook(Integer id, Book book) {
        Book bookFind = bookDao.findById(id);
        if (bookFind == null) {
            throw new NullPointerException("ID is not found!");
        }

        // update
        if (book.getTitle() != "") {
            bookFind.setTitle(book.getTitle());
        }
        if (book.getPublisher() != "") {
            bookFind.setPublisher(book.getPublisher());
        }
        if (book.getAuthor() != "") {
            book.setAuthor(book.getAuthor());
        }

        // save ke db
        bookDao.update(id, bookFind);
    }
}
