package com.cleancode;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * ChecksumFalseReturn
     */
    @Test
    public void checkSumShouldReturnFalse() {
        List<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        Code c = new Code(test);
        assertFalse(c.isCorrect());
    }

    /**
     * ChecksumTrueReturn
     */
    @Test
    public void checkSumShouldReturnTrue() {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        test.add(9);
        Code c = new Code(test);
        assertTrue(c.isCorrect());
    }

    /**
     * Check amount of codes in file
     */
    @Test
    public void getNbrCodeShouldReturnBetween1and25() {
        Reader reader = new Reader("./entry (1).txt");
        try {
            String content = reader.getFileContent();
            File file = new File(content, reader.getNbrLine());
            assertTrue(file.getNbrCode() >= 1 && file.getNbrCode() <=25);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturn1to9() {
        Reader reader = new Reader("./testFile1.txt");
        try {
            String content = reader.getFileContent();
            File file = new File(content, reader.getNbrLine());
            Parser parser = new Parser(file);
            List<Entry> entries = parser.parse();
            for (Entry entry : entries) {
                List<Integer> codes = new ArrayList<>();
                for (Item item : entry.getItems()) {
                    codes.add(parser.translate(item));
                }
                Code code = new Code(codes);
                assertEquals("123456789\n", code.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnInputPlusErr(){
        Reader reader = new Reader("./testFile2.txt");
        try {
            String content = reader.getFileContent();
            File file = new File(content, reader.getNbrLine());
            Parser parser = new Parser(file);
            List<Entry> entries = parser.parse();
            for (Entry entry : entries) {
                List<Integer> codes = new ArrayList<>();
                for (Item item : entry.getItems()) {
                    codes.add(parser.translate(item));
                }
                Code code = new Code(codes);
                assertEquals("223456789\tERR\n", code.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnInputPlusIll(){
        Reader reader = new Reader("./testFile3.txt");
        try {
            String content = reader.getFileContent();
            File file = new File(content, reader.getNbrLine());
            Parser parser = new Parser(file);
            List<Entry> entries = parser.parse();
            for (Entry entry : entries) {
                List<Integer> codes = new ArrayList<>();
                for (Item item : entry.getItems()) {
                    codes.add(parser.translate(item));
                }
                Code code = new Code(codes);
                assertEquals("?23456789\tILL\n", code.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
