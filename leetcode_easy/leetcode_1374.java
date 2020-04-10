package leetcode_easy;

public class leetcode_1374 {
    public static void main(String[] args) {

    }

    public static String generateTheString(int n) {
        StringBuilder res = new StringBuilder(n);
        if (n%2 == 1){
            res.append("a".repeat(n));
        } else {
            res.append("a".repeat(Math.max(0, n - 1)));
            res.append('b');
        }
        return res.toString();
    }
}
