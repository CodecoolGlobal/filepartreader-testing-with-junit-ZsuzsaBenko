package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private final String FILEPATH = "resources/test.txt";
    private Integer from = 1;
    private Integer to = 1;
    private FilePartReader filePartReader = new FilePartReader();

    @Test
    public void isFilePathCorrectAfterSetup() {
        filePartReader.setup(FILEPATH, from, to);
        assertEquals(FILEPATH, filePartReader.getFilePath());
    }

    @Test
    public void isFromLineCorrectAfterSetup() {
        filePartReader.setup(FILEPATH, from, to);
        assertEquals(from, filePartReader.getFromLine());
    }

    @Test
    public void isToLineCorrectAfterSetup() {
        filePartReader.setup(FILEPATH, from, to);
        assertEquals(to, filePartReader.getToLine());
    }

    @Test
    public void isFromLineLessThan1ThrowsException() {
        from = 0;
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(FILEPATH, from, to));
    }

    @Test
    public void isToLineLessThanFromLineThrowsException() {
        from = 2;
        to = 1;
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(FILEPATH, from, to));
    }

}