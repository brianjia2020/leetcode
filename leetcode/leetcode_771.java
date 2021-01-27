package leetcode;

import java.util.*;

public class leetcode_771 {
    public static void main(String[] args) {
        System.out.println(run("Aa", "AaaBBB"));
    }

    public static int run(String J, String S){
        ArrayList types = new ArrayList();
        for (int j =0; j < J.toCharArray().length; j++){
            types.add(J.toCharArray()[j]);
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++){
            if (types.contains(S.charAt(i))) {
                count += 1;
            }
        }
        return count;

    }
}
