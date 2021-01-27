package leetcode;

public class leetcode_709 {
    public static void main(String[] args) {
        System.out.println(toLowerCase("HDSFSD"));
        System.out.println(toLowerCase2("DHF*KEW"));
    }

    public static String toLowerCase(String str){
        String res = "";
        for (int i = 0; i < str.length(); i++){
            if ((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90 ) {
                res += (char) ((int) str.charAt(i) + 97-65);
            }
            else {
                res += str.charAt(i);
            }
        }
        return res;
    }

    public static String toLowerCase2(String str){
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 'a' - 'A';
            }
        }
        return String.valueOf(arr);
    }
}
