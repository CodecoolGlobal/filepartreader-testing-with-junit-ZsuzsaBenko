package com.codecool.filepartreader;

import java.io.*;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }

    public FilePartReader() {
        filePath = "/example.txt";
        fromLine = 0;
        toLine = 1000;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

    }

    public String read() throws IOException{
        String text = "";
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line;
            while ((line = br.readLine()) != null) {
                text = text.concat(line).concat("\n");
            }
        br.close();
        return text.substring(0, text.length()-1);
    }

    public String readLines() {
        String entireText = "";
        try {
            entireText = read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = "";
        String[] lines = entireText.split("\n");
        for (int i = fromLine - 1; i < Math.min(toLine, lines.length); i++) {
            result = result.concat(lines[i]).concat("\n");
        }
        return result.substring(0, result.length()-1);
    }
}
