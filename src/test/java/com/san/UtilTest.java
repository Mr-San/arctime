package com.san;

import com.san.util.Util;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UtilTest {
    @Test
    public void testSplit() throws Exception {
        String dir = "E:\\Workspace\\idea\\TEMP\\arctime\\src\\test\\resources\\";

        String source = dir + "source.txt";
        String chinese = dir + "chinese.txt";
        String english = dir + "english.txt";

        Util.split(source, chinese, english);
    }

    @Test
    public void testReplace() throws Exception {
        String dir = "E:\\Workspace\\idea\\TEMP\\arctime\\src\\test\\resources\\";

        String englishSrt = dir + "english.srt";
        String chineseTxt = dir + "chinese.txt";
        String chineseSrt = dir + "chinese.srt";

        Util.replace(englishSrt, chineseTxt, chineseSrt);
    }
}
