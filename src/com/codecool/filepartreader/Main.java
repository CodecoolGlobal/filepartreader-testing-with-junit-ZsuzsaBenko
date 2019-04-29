package com.codecool.filepartreader;

public class Main {
    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/test.txt", 1, 3);
        System.out.println(filePartReader.readLines());
    }
}
