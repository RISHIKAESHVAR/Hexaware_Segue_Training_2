package com.hexaware.Product_App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Cart cart = (Cart) context.getBean("cart");
        System.out.println(cart);
    }
}

