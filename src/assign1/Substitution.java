package assign1;

import java.util.ArrayList;
import java.util.Scanner;

public class Substitution {
    public static void main(String[] args) throws Exception {
        System.out.print("Do you want to [E]ncrypt (default) or [D]ecrypt: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print("Enter your key (max 8 chars): ");
        String key = sc.nextLine();
        System.out.print("Enter your input path: ");
        String loc = sc.nextLine();
        String[] arr = FileHandle.read(loc);
        String[] arr2 = new String[arr.length];
        System.out.print("Enter your output path: ");
        String loc2 = sc.nextLine();

        if (s.toUpperCase().equals("D")) {
            System.out.println("Decryption mode");
            for (int i = 0; i<arr.length; i++) {
                arr2[i] = decryption(arr[i],key);
            }
            FileHandle.write(arr2,loc);
        } else {
            System.out.println("Encryption mode");
            for (int i = 0; i<arr.length; i++) {
                arr2[i] = encryption(arr[i],key);
            }
            FileHandle.write(arr2,loc2);
        }
    }

    private static String encryption(String text, String key) {
        String temp = "";
        for (int i = 0, j = 0; i<text.length(); i++) {
            temp += Character.toString(text.charAt(i) + key.charAt(j)+65);
            j++;
            if (j >= key.length()) {
                j = 0;
            }
        }
        return temp;
    }

    private static String decryption(String text, String key) {
        String temp = "";
        for (int i = 0, j=0; i<text.length(); i++) {
            temp+= Character.toString(text.charAt(i) - key.charAt(j)-65);
            j++;
            if (j >= key.length()) {
                j = 0;
            }
        }
        return temp;
    }
}
