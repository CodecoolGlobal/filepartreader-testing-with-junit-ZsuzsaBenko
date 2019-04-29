package com.codecool.filepartreader;

import java.io.*;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "/example.txt";
        fromLine = 0;
        toLine = 1000;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
    }

    private String read(){
        String text = "";
        File file = new File(filePath);
        FileReader fileReader = null;
        try {
           fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fileReader);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                text = text.concat(line).concat("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.substring(0, text.length()-1);
    }

    public String readLines(){
        String entireText = read();
        String result = "";
        String[] lines = entireText.split("\n");
        for (int i = fromLine - 1; i < toLine; i++) {
            result = result.concat(lines[i]).concat(" ");
        }
        return result.substring(0, result.length()-1);
    }
}
