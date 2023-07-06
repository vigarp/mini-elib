package library;

import java.util.List;
import java.util.Scanner;

import library.dao.BookDao;
import library.dao.UserDao;
import library.model.Book;
import library.model.User;
import library.service.book.BookService;
import library.service.book.BookServiceImpl;
import library.service.user.UserService;
import library.service.user.UserServiceImpl;

public class Main {
  static UserDao userDao = new UserDao();
  static UserService userService = new UserServiceImpl(userDao);

  static BookDao bookDao = new BookDao();
  static BookService bookService = new BookServiceImpl(bookDao);

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    try {
      String opsi;
      do {
        User user;
        Book book;
        System.out.println("===== MENU SISTEM =====");
        System.out.print("Input menu: ");
        String menu = in.nextLine();

        switch (menu) {
          case "1":
            System.out.println("INPUT USER");
            user = new User();
            System.out.print("Input email: ");
            user.setEmail(in.nextLine());
            System.out.print("Input full name: ");
            user.setFullname(in.nextLine());
            System.out.print("Input password: ");
            user.setPassword(in.nextLine());
            userService.createUser(user);
            System.out.println();
            break;

          case "2":
            System.out.println("TAMPILKAN USER");
            List<User> users = userService.getUsers();
            for (int i = 0; i < users.size(); i++) {
              System.out.print((i + 1) + ". ");
              User u = users.get(i);
              u.getInfo();
            }
            System.out.println();
            break;

          case "3":
            System.out.println("PERBARUI DATA USER");
            System.out.println("TAMPILKAN USER");
            List<User> users2 = userService.getUsers();
            for (int i = 0; i < users2.size(); i++) {
              System.out.print((i + 1) + ". ");
              User u = users2.get(i);
              u.getInfo();
            }
            System.out.println();

            System.out.println("INPUT USER");
            user = new User();
            System.out.print("Input id user: ");
            int id = Integer.valueOf(in.nextLine());
            System.out.print("Input email: ");
            user.setEmail(in.nextLine());
            System.out.print("Input full name: ");
            user.setFullname(in.nextLine());
            System.out.print("Input password: ");
            user.setPassword(in.nextLine());

            // service
            userService.updateUser(id, user);
            System.out.println();
            break;

          case "4":
            System.out.println("INPUT BUKU");
            book = new Book();
            System.out.print("Input title: ");
            book.setTitle(in.nextLine());
            System.out.print("Input Publisher name: ");
            book.setPublisher(in.nextLine());
            System.out.print("Input Author name: ");
            book.setAuthor(in.nextLine());
            bookService.createBook(book);
            System.out.println();
            break;

          case "5":
            System.out.println("TAMPILKAN BUKU");
            List<Book> books = bookService.getBooks();
            for (int i = 0; i < books.size(); i++) {
              System.out.print((i + 1) + ". ");
              Book b = books.get(i);
              b.getInfo();
            }
            System.out.println();
            break;

          case "6":
            System.out.println("PERBARUI BUKU");
            System.out.println("TAMPILKAN BUKI");
            List<Book> books2 = bookService.getBooks();
            for (int i = 0; i < books2.size(); i++) {
              System.out.print((i + 1) + ". ");
              Book b = books2.get(i);
              b.getInfo();
            }
            System.out.println();

            System.out.println("INPUT BUKU");
            book = new Book();
            System.out.print("Input id buku: ");
            int idBook = Integer.valueOf(in.nextLine());
            System.out.print("Input title: ");
            book.setTitle(in.nextLine());
            System.out.print("Input Publisher name: ");
            book.setPublisher(in.nextLine());
            System.out.print("Input Author name: ");
            book.setAuthor(in.nextLine());

            // service
            bookService.updateBook(idBook, book);
            System.out.println();
            break;

          default:
            break;
        }

        System.out.print("\nApakah mau keluar sistem? (y|n): ");
        opsi = in.nextLine();
        System.out.println();
      } while (opsi.equalsIgnoreCase("n"));

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      in.close();
    }
  }
}
