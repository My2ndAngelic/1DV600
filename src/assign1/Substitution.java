package assign1;

import java.util.Scanner;

public class Substitution {
    public static void main(String[] args) throws Exception {
        System.out.print("Do you want to [E]ncrypt (default) or [D]ecrypt: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print("Enter your key (0-255): ");
        int key = Integer.parseInt(sc.nextLine());
        if (key < 0 || key > 255) {
            System.err.println("Invalid key.");
            System.exit(-1);
        }
        System.out.print("Enter your input path: ");
        String loc = sc.nextLine();

        System.out.print("Enter your output path (will be overwritten): ");
        String loc2 = sc.nextLine();

        String[] arr = FileHandle.read(loc);
        String[] arr2 = new String[arr.length];
        if (s.toUpperCase().equals("D")) {
            System.out.print("Decrypting: ");
            for (int i = 0; i<arr.length; i++) {
                arr2[i] = decryption(arr[i],key);
            }
        } else {
            System.out.print("Encrypting: ");
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = encryption(arr[i], key);
            }
        }
        System.out.println("Completed");
        FileHandle.write(arr2,loc2);
        sc.close();
    }

    static String encryption(String text, int key) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i<text.length(); i++) {
            temp.append(Character.toString(text.charAt(i) + key));
        }
        return temp.toString();
    }

    static String decryption(String text, int key) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i<text.length(); i++) {
            temp.append(Character.toString(text.charAt(i) - key));
        }
        return temp.toString();
    }
}
