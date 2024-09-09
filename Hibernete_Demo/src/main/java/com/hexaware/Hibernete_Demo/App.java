package com.hexaware.Hibernete_Demo;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

    SessionFactory fac;
    Session ses;
    Transaction tx;

    App() {
        fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
        ses = fac.openSession();
    }

    void insertBook() {
        tx = ses.beginTransaction();
        Book b = new Book();
        b.setBno(1);
        b.setName("ML");
        b.setPrice(200.0);
        ses.save(b);
        tx.commit();
        System.out.println("Updated!");
    }

    void removeByBNo(int bNo) {
        tx = ses.beginTransaction();
        Book b = ses.find(Book.class, bNo);
        if (b != null) {
            ses.delete(b);
            tx.commit();
            System.out.println("Deleted!");
        } else {
            System.out.println("Book Not Found...");
        }
    }

    void updatePriceByBNo(int bNo, double price) {
        tx = ses.beginTransaction();
        Book b = ses.find(Book.class, bNo);
        if (b != null) {
            b.setPrice(price);
            ses.update(b);
            tx.commit();
            System.out.println("Price Updated!");
        } else {
            System.out.println("Book Not Found...");
        }
    }

    String getNameByBNo(int bNo) {
        Book b = ses.find(Book.class, bNo);
        if (b != null) {
            return b.getName();
        } else {
            return "Book Not Found...";
        }
    }

    void findall() {
        tx = ses.beginTransaction();
        Query<Book> query = ses.createQuery("from Book", Book.class);
        List<Book> books = query.getResultList();
        tx.commit();

        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);

        // Uncomment the desired operation
        // app.insertBook();
        // app.removeByBNo(10);
        // System.out.println("Enter the Book Number: ");
        // int bNo = sc.nextInt();
        // sc.nextLine();
        // System.out.println("Enter the new Price: ");
        // double newPrice = sc.nextDouble();
        // app.updatePriceByBNo(bNo, newPrice);

        // Retrieve book name by book number
        // System.out.println("Enter the Book Number to retrieve the name: ");
        // int bNo = sc.nextInt();
        // String name = app.getNameByBNo(bNo);
        // System.out.println("Book Name: " + name);

        // Retrieve all books
        app.findall();

        sc.close();
        app.ses.close();
        app.fac.close();
    }
}
