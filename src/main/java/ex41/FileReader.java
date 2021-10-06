package ex41;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileReader {
    public static List<String> output = new LinkedList<>();
    public static String[] names;
    public static String path;
    // Constructor
    public FileReader (String path) throws IOException {
        FileReader.path = path;
        readFile();
    }
    // Read in the file and save to list
    public void readFile() throws IOException {
        BufferedReader input = new BufferedReader(new java.io.FileReader(path));
        String line;

        while((line = input.readLine()) != null) {
            output.add(line);
        }
        names = alphabetize();
    }

    public static String[] alphabetize() {
        String[] names = output.toArray(new String[output.size()]);
        Arrays.sort(names);
        return names;
    }
    // Getter to return list as array
    public static String[] getValues() {
        return names;
    }
}
