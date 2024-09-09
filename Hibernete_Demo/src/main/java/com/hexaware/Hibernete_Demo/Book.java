package com.hexaware.Hibernete_Demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITBook")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bno")
    private int bno;

    @Column(name = "bkname", nullable = false)
    private String name;

    @Column(name = "price")
    private Double price;

    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(int bno, String name, Double price) {
        this.bno = bno;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [bno=" + bno + ", name=" + name + ", price=" + price + "]";
    }
}
