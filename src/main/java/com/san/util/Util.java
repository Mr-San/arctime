package com.san.util;

import java.io.*;

/**
 * Hello world!
 */
public class Util {
    public static void split(String source, String chinese, String english) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(source)));
        BufferedReader br = new BufferedReader(isr);

        BufferedWriter bw1 = new BufferedWriter(new FileWriter(chinese));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(english));

        String line = null;
        boolean flag = false;

        try {
            while ((line = br.readLine()) != null) {
                line = line + "\n";
                if (flag) {
                    // TODO：中文替换（，|。|,|？）为空格
                    line = line.replaceAll("，|。|,|？|！", " ");
                    bw1.write(line);
                    bw1.flush();
                } else {
                    // TODO：英文替换英文字符（，。‘’“”！？）为中文字符
                    line = line.replaceAll("，", ",");
                    line = line.replaceAll("。", ".");
                    line = line.replaceAll("‘", "'");
                    line = line.replaceAll("’", "'");
                    line = line.replaceAll("“", "\"");
                    line = line.replaceAll("”", "\"");
                    line = line.replaceAll("！", "!");
                    line = line.replaceAll("？", "?");

                    bw2.write(line);
                    bw2.flush();
                }

                flag = !flag;
            }
        } finally {
            bw1.close();
            bw2.close();

            br.close();
            isr.close();
        }
    }

    public static void replace(String englishSrt, String chineseTxt, String chineseSrt) throws Exception {
        InputStreamReader isr1 = new InputStreamReader(new FileInputStream(new File(englishSrt)));
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream(new File(chineseTxt)));
        BufferedReader br1 = new BufferedReader(isr1);
        BufferedReader br2 = new BufferedReader(isr2);

        BufferedWriter bw = new BufferedWriter(new FileWriter(chineseSrt));

        String line1 = null;
        String line2 = null;
        String line = null;
        int i = 1;

        try {
            while ((line1 = br1.readLine()) != null) {
                line = null;
                line = line1 + "\n";

                if ((i + 1) % 4 == 0) {
                    line2 = br2.readLine() + "\n";
                    line = line2;
                }

                bw.write(line);
                bw.flush();

                i++;
            }
        } finally {
            bw.close();

            br1.close();
            br2.close();
            isr1.close();
            isr2.close();
        }
    }
}
