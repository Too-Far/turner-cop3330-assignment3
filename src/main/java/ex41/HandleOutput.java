package ex41;

import java.io.OptionalDataException;

public class HandleOutput {
    private static String[] names;
    public HandleOutput (String [] names) {
        HandleOutput.names = names;
        outputInfo();
    }

    public static void outputInfo() {
        System.out.println("Total of " + names.length + " names");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
