package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

class ParseOutput {
     ParseOutput() {}
    public static void outputData(String[][] args) {
        String format = "%-10s%-10s%-10s\n";
        System.out.format(format, "Last", "First", "Salary");
        System.out.println("------------------------------");
        for (String[] arg : args) {
            System.out.format(format, arg[0], arg[1], arg[2]);
        }
        }
    }

class ReadData extends Reader {
    public static List<String[]> output = new LinkedList<>();
    public static int numInnerArrays = 0;
    public static String path;
    // Constructor
    public ReadData (String path) throws IOException {
        ReadData.path = path;
        readFile();
    }
    // Read in the file and save to list
    public void readFile() throws IOException {
        BufferedReader input = new BufferedReader(new java.io.FileReader(path));
        String line;
        while ((line = input.readLine()) != null) {
            String[] data = line.split(",");
            output.add(data);
            numInnerArrays ++;
        }
    }
        // Getter for output list
    public static String[][] getList() {
            return  output.toArray(new String[output.size()][numInnerArrays]);
        }

    @Override
    public int read(char[] cbuf, int off, int len) {
        return 0;
    }

    @Override
    public void close() {

    }
}

public class App {
    public static void main( String[] args ) throws IOException {
        new ReadData("src/main/java/ex42/exercise42_input.txt");
        String[][] data = ReadData.getList();
        new ParseOutput();
        ParseOutput.outputData(data);
    }
}
