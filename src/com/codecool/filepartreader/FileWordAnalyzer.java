package com.codecool.filepartreader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        List<String> words = getWordList();
        Collections.sort(words);
        return words;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        List<String> words = getWordList();
        return words.stream().filter(word -> word.contains(subString)).collect(Collectors.toList());
    }

    public List getStringsWhichArePalindromes() {
        List<String> words = getWordList();
        return words.stream().filter(word -> word.equals(reverseWord(word))).collect(Collectors.toList());
    }

    private List<String> getWordList() {
        String lines = filePartReader.readLines();
        String[] words = lines.split("\\s");
        return Arrays.asList(words);
    }

    private String reverseWord(String word) {
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord.concat(String.valueOf(word.charAt(i)));
        }
        return reversedWord;
    }

}
