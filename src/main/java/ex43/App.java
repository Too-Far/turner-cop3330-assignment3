package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Turner
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

class WriteFiles {

    public static void writeDirectory(String title) throws IOException {
        String baseFile = "./src/main/java/ex43/website";
        Path intPath = Paths.get(baseFile);
        if (!Files.exists(intPath)) {
            Files.createDirectory(intPath);
        }
        String fileName = "./src/main/java/ex43/website/" + title;
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
            System.out.println("Created ./website/" + title);
        } else {
            System.out.println("Directory not created, ./website/" + title + " already exists.");
        }
    }

    public static void createHTMLFile(String title) {
        try {
            File html = new File("src/main/java/ex43/website/" + title + "/index.html");
            html.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating HTML file");
        }
    }

    public static void writeHtml(String author, String title) {
        String htmlBoilerplate =
                "<!doctype html>\n" +
                        "\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "  <title>" + author + "</title>\n" +
                        "  <link rel=\"stylesheet\" href=\"css/.css?v=1.0\">\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "  <!-- your content here... -->\n" +
                        "  <script src=\"js/scripts.js\"></script>\n" +
                        "</body>\n" +
                        "</html>";
        createHTMLFile(title);
        try {
            FileWriter writer = new FileWriter("src/main/java/ex43/website/" + title + "/index.html");
            writer.write(htmlBoilerplate);
            writer.close();
            System.out.println("Created ./website/" + title + "/index.html");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the HTML file contents");
        }
    }

    public static void writeCss(boolean css, String title) throws IOException {
        if (css) {
            String fileName = "./src/main/java/ex43/website/" + title + "/css";
            Path path = Paths.get(fileName);
            if (!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("Created ./website/" + title + "/css");
            } else {
                System.out.println("Directory not created, ./website/" + title + "/css already exists");
            }
        }
    }

    public static void writeJS(boolean js, String title) throws IOException {
        if (js) {
            String fileName = "./src/main/java/ex43/website/" + title + "/js";
            Path path = Paths.get(fileName);
            if (!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("Created ./website/" + title + "/js");
            } else {
                System.out.println("Directory not created, ./website" + title + "/js already exists");
            }
        }
    }
}

class GatherInput {
    public static String title;
    public static String author;
    public static boolean javascript = false;
    public static boolean css = false;

    public static void gatherVariables() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the name of the site?");
        title = reader.readLine();

        System.out.println("Who is the author? ");
        author = reader.readLine();

        System.out.println("Would you like a CSS file (y/n)?");
        String value = reader.readLine();
        if (Objects.equals(value, "y")) {
            css = true;
        }

        System.out.println("Would you like a Javascript file?");
        String v = reader.readLine();
        if (Objects.equals(v, "y")) {
            javascript = true;
        }
    }

    public static String getAuthor() {
        return author;
    }

    public static String getTitle() {
        return title;
    }

    public static boolean getCSS() {
        return css;
    }

    public static boolean getJS() {
        return javascript;
    }
}

public class App {
    public static void main(String[] args) throws IOException {
        GatherInput.gatherVariables();
        String title = GatherInput.getTitle();
        WriteFiles.writeDirectory(title);
        WriteFiles.writeHtml(GatherInput.getAuthor(), title);
        WriteFiles.writeCss(GatherInput.getCSS(), title);
        WriteFiles.writeJS(GatherInput.getJS(), title);
    }
}
