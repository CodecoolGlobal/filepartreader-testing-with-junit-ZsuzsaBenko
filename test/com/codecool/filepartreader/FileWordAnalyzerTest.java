package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private FilePartReader filePartReader = new FilePartReader();
    private final String FILEPATH = "resources/test.txt";
    private Integer from = 1;
    private Integer to = 5;

    @Test
    void isWordListInAlphabeticalOrder() {
        filePartReader.setup(FILEPATH, from, to);
        FileWordAnalyzer wordAnalyzer = new FileWordAnalyzer(filePartReader);
        List<String> expectedWordList = new ArrayList<>(Arrays.asList("bluer", "canoe", "cat", "evening", "kayak",
                "madam", "palindrome", "peep", "racecar", "redder", "redivider", "refer", "stats", "tenet", "yellower"));
        assertIterableEquals(expectedWordList, wordAnalyzer.getWordsOrderedAlphabetically());
    }
    @Test
    void doesWordListContainWordsWithGivenSubstringOnly() {
        filePartReader.setup(FILEPATH, from, to);
        FileWordAnalyzer wordAnalyzer = new FileWordAnalyzer(filePartReader);
        List<String> expectedWordList = new ArrayList<>(Arrays.asList("redivider", "yellower", "redder", "bluer", "refer"));
        assertIterableEquals(expectedWordList, wordAnalyzer.getWordsContainingSubstring("er"));
    }

    @Test
    void doesWordListConsistOfPalindromesOnly() {
        filePartReader.setup(FILEPATH, from, to);
        FileWordAnalyzer wordAnalyzer = new FileWordAnalyzer(filePartReader);
        List<String> expectedWordList = new ArrayList<>(Arrays.asList("redivider", "racecar", "redder", "madam", "kayak",
                "refer", "stats", "tenet", "peep"));
        assertIterableEquals(expectedWordList, wordAnalyzer.getStringsWhichArePalindromes());
    }

}