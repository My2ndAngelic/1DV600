package assign1;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Transposition {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Key requirement: contains digit 1-9, max digit must not exceed key length, no duplicate digit.");
        System.out.print("Please enter your key: ");
        int key = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter your input file: ");
        String inloc = sc.nextLine();
        System.out.print("Please enter your output file (will be overwritten): ");
        String outloc = sc.nextLine();

        String keystr = Integer.toString(key);
        int[] keyarr = new int[keystr.length()];
        for (int i = 0; i<keystr.length(); i++) {
            keyarr[i] = Integer.parseInt(Character.toString(keystr.charAt(i)));
        }

        if (!isValidKey(keyarr)) {
            System.err.println("Key is not valid");
            System.exit(-1);
        }
        work(inloc,outloc,keyarr);
    }

    static void work(String in, String out, int[] keyarr) throws Exception {
        String[] aa = FileHandle.read(in);
        for (int i = 0; i<aa.length; i++) {
            aa[i] = swapAndreturn(aa[i],keyarr);
        }
        FileHandle.write(aa,out);
    }

    static String swapAndreturn(String a, int[] arr) {
        int keylength = arr.length;
        int stringlength = a.length();
        int temp = stringlength % keylength;
        if (temp != 0) {
            for (int i = 0; i < keylength - temp; i++) {
                a += " ";
            }
        }

        double temp2 = (double) stringlength / keylength;
        temp = (int) Math.ceil(temp2);
        String[] split = new String[temp];
        char[][] aa = new char[temp][keylength];
        for (int i = 0; i<temp; i++) {
            split[i] = a.substring(i*keylength,(i+1)*keylength);
        }
        for (int i = 0; i<temp; i++) {
            aa[i] = Arrays.copyOf(split[i].toCharArray(),split[i].length());
        }

        for (int i = 0; i<temp; i++) {
            aa[i] = swapChar(aa[i],arr);
        }

        StringBuilder finalbro = new StringBuilder();
        for (char[] chars : aa) {
            for (char aChar : chars) {
                finalbro.append(aChar);
            }
        }
        return finalbro.toString();
    }

    // Find duplication
    static boolean containDuplicate(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            for (int k = i+1; k<arr.length; k++) {
                if (arr[k] == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Swap
    static char[] swapChar(char[] arr, int[] key) {
        char[] temp = new char[arr.length];
        for (int i = 0; i<key.length; i++) {
            temp[i] = arr[key[i]-1];
        }
        return temp;
    }

    // Find maximum
    static int findMax(int[] arr) {
        int k = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (k < arr[i]) {
                k = arr[i];
            }
        }
        return k;
    }

    // Everything larger than
    static boolean isValidNumber(int[] arr) {
        for (int a : arr) {
            if (a <= 0) {
                return false;
            }
        }
        return true;
    }

    static boolean containOne(int[] arr) {
        for (int a : arr) {
            if (a == 1) {
                return true;
            }
         }
        return false;
    }

    static boolean containZero(int[] arr) {
        for (int a : arr) {
            if (a == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean isValidKey(int[] arr) {
        return findMax(arr) <= arr.length && !containDuplicate(arr) && isValidNumber(arr) && containOne(arr) && !containZero((arr));
    }
}
