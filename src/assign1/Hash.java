package assign1;

import java.util.ArrayList;
import java.util.Arrays;

public class Hash {
    public static void main(String[] args) {
        System.out.println("Hello World");
//        String str = "hello";
//        String str2 = "hellp";
//        byte[] bla = str.getBytes();
//        byte[] bla2 = str2.getBytes();
//        System.out.println(hashF(bla));
//        System.out.println(hashF(bla2));
//        System.out.println(hashF("hellq".getBytes()));
        String a = "hello";
        String b = "world";

        String alphanumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int[] aa = new int[alphanumeric.length()*2];
        for (int i = 0; i < alphanumeric.length(); i++) {
            String temp = a + alphanumeric.charAt(i);
            String temp2 = b + alphanumeric.charAt(i);
            aa[i] = hashF(temp.getBytes());
            aa[aa.length-i-1] = hashF(temp2.getBytes());
        }
//        System.out.println(Arrays.toString(aa));

        System.out.println(hashF("hello".getBytes()));

        // Hash function
        for (int i = 0; i < 1000; i++) {
//            System.out.println(hashF(new byte[]{(byte) i}));
        }
    }

    static int hashF(byte[] msg) {
        int hash = 11;
        for (int j = 0; j<7; j++) {
            for (byte b : msg) {
                hash = ((hash << 3) ^ (hash >> 5) ^ b);
            }
        }
        return (hash & 0xFFFF);
    }
}
