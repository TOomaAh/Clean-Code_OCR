package com.cleancode;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cleancode.Models.Code;
import com.cleancode.Models.File;
import com.cleancode.Reader.Reader;

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
            assertTrue(  1 <= file.getNbrEntry() && file.getNbrEntry() <= 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturn1to9() {
        try {
            OCR ocr = new OCR("./testFile1.txt");
            List<Code> codes = ocr.getAllCode();
            Code code = codes.get(0);
            assertEquals("123456789\n", code.format());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnInputPlusErr(){
        try {
            OCR ocr = new OCR("./testFile2.txt");
            List<Code> codes = ocr.getAllCode();
            Code code = codes.get(0);
            assertEquals("223456789\tERR\n", code.format());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnInputPlusIll(){

        try{
            OCR ocr = new OCR("./testFile3.txt");
            List<Code> codes = ocr.getAllCode();
            Code code = codes.get(0);
            assertEquals("?23456789\tILL\n", code.format());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
