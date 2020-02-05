package assign1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Secret {
    public static void main(String[] args) throws Exception {
        String str = "Hello";

        FileInputStream fin = new FileInputStream("/Users/My2ndAngelic/Downloads/Secret.bmp");
        int len;
        byte data[] = new byte[16];

        // I used this website: http://www.java2s.com/Code/Java/File-Input-Output/Readbytesanddisplaytheirhexadecimalvalues.htm
        // Read bytes until EOF is encountered.
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList<String> arrstr = new ArrayList<>();
        do {
            len = fin.read(data);
            for (int j = 0; j < len; j++) {
//                System.out.printf("%02X ", data[j]);
                String a = String.format("%02X",data[j]);
                    sb.append(a).append(" ");
                    arrstr.add(a);
            }
        } while (len != -1);

        System.out.println(arrstr.get(54));
        for (int i = 54; i<200; i++) {
            String a = arrstr.get(i);

            int i1 = Integer.parseInt(String.valueOf(a.charAt(1)), 16) % 2;
            if (i1 == 1) {
                sb2.append("1");
            } else if (i1 == 0) {
                sb2.append("0");
            }
        }
        for (int i = 0; i < sb2.length(); i++) {
            if (i % 9 == 0) {
                sb2.insert(i," ");
            }
        }
        System.out.println(sb2);


//        System.out.println(sb2);

    }
}
