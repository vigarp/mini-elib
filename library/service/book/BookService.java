package library.service.book;

import java.util.List;

import library.model.Book;

public interface BookService {
  // kerangka method CRUDnya
  void createBook(Book book);

  List<Book> getBooks();

  void updateBook(Integer id, Book book);
}
