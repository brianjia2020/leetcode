package leetcode;

public class leetcode_1309 {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }

    public static String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i ++){
            int basic = 'a' - 1;
            int offset = 0;
            if (i + 2 < len && s.charAt(i+2) == '#'){
                offset = (s.charAt(i++) - '0') * 10 + (s.charAt(i++) - '0');
            } else {
                offset = s.charAt(i) - '0';
            }
            stringBuilder.append((char) (basic + offset));
        }
        return stringBuilder.toString();
    }
}
