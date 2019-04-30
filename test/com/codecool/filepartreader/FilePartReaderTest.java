package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private final String FILEPATH = "../resources/test.txt";
    private Integer from = 1;
    private Integer to = 1;
    private FilePartReader filePartReader = new FilePartReader();

    @Test
    void isFilePathCorrectAfterSetup() {
        filePartReader.setup(FILEPATH, from, to);
        assertEquals(FILEPATH, filePartReader.getFilePath());
    }

    @Test
    void isFromLineCorrectAfterSetup() {
        filePartReader.setup(FILEPATH, from, to);
        assertEquals(from, filePartReader.getFromLine());
    }

    @Test
    void isToLineCorrectAfterSetup() {
        filePartReader.setup(FILEPATH, from, to);
        assertEquals(to, filePartReader.getToLine());
    }

    @Test
    void isFromLineLessThan1ThrowsException() {
        from = 0;
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(FILEPATH, from, to));
    }

    @Test
    void isToLineLessThanFromLineThrowsException() {
        from = 2;
        to = 1;
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(FILEPATH, from, to));
    }

    @Test
    void isFilePathIncorrectThrowsException() {
        from = 1;
        to = 2;
        filePartReader.setup("/test.txt", from, to);
        assertThrows(IOException.class, () -> filePartReader.read());
    }

    @Test
    void areAllLinesReturnedWhenEntireFileIsRead() throws IOException {
        from = 1;
        to = 10;
        filePartReader.setup(FILEPATH, from, to);
        String expectedString = "redivider racecar cat\n" +
                                "yellower redder bluer\n" +
                                "madam kayak canoe\n" +
                                "refer stats evening\n" +
                                "tenet peep palindrome\n" +
                                "gag mum apples\n" +
                                "pop pup freckles\n" +
                                "tit bird dragon\n" +
                                "wow radar sleepy\n" +
                                "nun priest church";
        assertEquals(expectedString, filePartReader.read());
    }

    @Test
    void areCorrectLinesReturnedWhenFilePartIsRead() {
        from = 3;
        to = 6;
        filePartReader.setup(FILEPATH, from, to);
        String expectedString =
                "madam kayak canoe\n" +
                "refer stats evening\n" +
                "tenet peep palindrome\n" +
                "gag mum apples";
        assertEquals(expectedString, filePartReader.readLines());
    }

}