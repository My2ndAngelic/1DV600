package assign1;

public class Hash {
    public static void main(String[] args) {
        // Hash function
        // Source:
        for (int i = 0; i < 10000; i++) {
            System.out.println(hashF(Integer.toString(i)));
        }
    }

    // Source: https://stackoverflow.com/questions/2624192/good-hash-function-for-strings
    static int hashF(String msg) {
        int hash = 101;
        for (int i = 0; i < msg.length(); i++) {
            hash = hash*31 + msg.charAt(i);
        }
        return hash & 0xFFFF;
    }
}
