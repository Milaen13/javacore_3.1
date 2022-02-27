package com.company;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        // Установка

        String directory = "/Users/ludmilaengberg/hemjobb/Games/";
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File(directory),
                new File(directory + "temp"),
                new File(directory + "src"),
                new File(directory + "res"),
                new File(directory + "savegames"),
                new File(directory + "src/main"),
                new File(directory + "src/test"),
                new File(directory + "res/drawables"),
                new File(directory + "res/vectors"),
                new File(directory + "res/icons")
        );
        List<File> fileList = Arrays.asList(
                new File(directory + "src/main/Main.java"),
                new File(directory + "src/main/Utils.java"),
                new File(directory + "temp/temp.txt")
        );

        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append(folder + " создан\n");
            System.out.print(folder + " создан\n");
        });

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append(file + " создан\n");
                System.out.print(file + " создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');

            }
        });

        try (FileWriter log = new FileWriter(directory + "temp/temp.txt", false)) {
            log.write(sb.toString());
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader(directory + "temp/temp.txt"))) {
            String text;
            while ((text = br.readLine()) != null) System.out.println(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
