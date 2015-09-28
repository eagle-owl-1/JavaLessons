
package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileArrayProvider {

    public static ArrayList<String> readLines(String fileName) throws IOException {
        File file = new File(FileArrayProvider.class.getClassLoader().getResource(fileName).getFile());
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void putLines(String filename, ArrayList list) throws IOException {
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filename), "utf-8")))
        {
            for (int i = 0; i < list.size(); i++) {
                writer.write((list.get(i)).toString()+"\n");
            }
        }
    }

}

