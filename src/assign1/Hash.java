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
        for (int j = 1; j < 12; j++) {
            for (int i = 0; i < msg.length(); i++) {
                hash = hash ^ (hash << 2);
                hash = hash ^ (hash >> 3);
                hash = hash * 31;
                hash = hash ^ msg.charAt(i);
            }
        }
        return hash & 0xFFFF;
    }
}
