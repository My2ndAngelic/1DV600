package assign1;

import java.util.ArrayList;

public class Hash {
    public static void main(String[] args) {
        System.out.println("Hello World");
        String str = "hello";
        String str2 = "hellp";
        byte[] bla = str.getBytes();
        byte[] bla2 = str2.getBytes();
        System.out.println(hashF(bla));
        System.out.println(hashF(bla2));
        System.out.println(hashF("hellq".getBytes()));
    }

    static int hashF(byte[] msg) {
        int hash = 31;
        for (int j = 0; j<8; j++) {
            for (byte b : msg) {
                hash = ((hash << 3) ^ (hash >> 7) ^ b);
            }
        }
        return (hash & 0xFFFF);
    }

    static void hashTest1() {
        String first = "abcdefghijklmnopqrstuvwxyz";
        char[] set = first.toCharArray();
        for (int i = 0; i<10; i++) {

        }
    }

    static void hashTest2() {

    }
}
