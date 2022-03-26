package de.exxcellent.challenge.impl;

import de.exxcellent.challenge.exception.ReadFileException;
import de.exxcellent.challenge.parser.api.Parser;
import de.exxcellent.challenge.parser.impl.CsvParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CsvParserTest {
    Parser parser;
    String correctFilePath = "/de/exxcellent/challenge/football.csv";
    String emptyFilePath = "/de/exxcellent/challenge/empty.csv";
    String incorrectFilePath = "/de/challenge/football.csv";

    @BeforeEach
    void setUp() { parser = new CsvParser(); }

    @Test
    void checkWithCorrectFilePath() {
        assertDoesNotThrow(() -> parser.readData(correctFilePath), "Cannot read file with correct filepath");
    }

    @Test
    void checkWithIncorrectFilePath() {
        assertThrows(ReadFileException.class, () -> parser.readData(incorrectFilePath), "File with incorrect filepath didn't throw an exception");
    }

    @Test
    void readFileWithData() {
        assertEquals(20, parser.readData(correctFilePath).size(), "Wrong amount of entries");
    }

    @Test
    void readFileWithoutData() {
        assertEquals(0, parser.readData(emptyFilePath).size());
    }
}
