package assign1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Pick your method, [S]ubstitution (default) or [T]ransposition: ");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        if (a.toUpperCase().equals("T")) {
            Transposition.main(new String[0]);
        } else {
            Substitution.main(new String[0]);
        }
    }
}
