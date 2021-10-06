package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Turner
 */


import java.io.IOException;


public class App {
    public static HandleOutput main (String[] args) throws IOException {
        new FileReader("src/main/java/ex41/exercse41_input.txt");
        String[] arrayOfnames = FileReader.getValues();
        return new HandleOutput(arrayOfnames);
    }
}
