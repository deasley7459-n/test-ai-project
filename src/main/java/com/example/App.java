package com.example;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java com.example.App <name>");
            System.out.println("Example: java com.example.App World");
            return;
        }
        System.out.println(greet(args[0]));
    }

    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}
