package company_questions.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q30_SubStringOfSizeK {
    public static void main(String[] args) {
        String s = "abcabc";
        int k = 3;
        System.out.println(kSubstring(s,k));
    }

    //window
    public static List<String> kSubstring(String s, int k) {
        Set<Character> window = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            for (; window.contains(s.charAt(end)); start++) {
                window.remove(s.charAt(start));
            }

            window.add(s.charAt(end));

            if (window.size() == k) {
                result.add(s.substring(start, end + 1));
                window.remove(s.charAt(start++));
            }
        }
        return new ArrayList<>(result);
    }

    //brute force
    public static List<String> findKSubString(int k, String s){
        if(s==null||s.length()<k) return new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length()-k;i++){
            if(!containsDuplicateChar(s.substring(i,k))) set.add(s.substring(i,i+k));
        }
        return new ArrayList<>(set);
    }

    public static boolean containsDuplicateChar(String s){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))) return true;
            set.add(s.charAt(i));
        }
        return false;
    }
}
