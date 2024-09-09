package com.hexa.maven1.com.hexamaven1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Load the Spring context from the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve and print each bean
        Cricket_Player s1 = (Cricket_Player) context.getBean("player1");
        Cricket_Player s2 = (Cricket_Player) context.getBean("player2");
        Cricket_Player s3 = (Cricket_Player) context.getBean("player3");
        Cricket_Player s4 = (Cricket_Player) context.getBean("player4");

        // Print bean details
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
