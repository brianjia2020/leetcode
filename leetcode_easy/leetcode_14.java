package leetcode_easy;

public class leetcode_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String minStr = strs[0];
        for(String str: strs){
            if (str.length() < minStr.length()){
                minStr = str;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i =0; i<minStr.length();i++){
            char c = minStr.charAt(i);
            boolean isConsistent = true;
            for (String str: strs){
                if (str.charAt(i) != c) {
                    isConsistent = false;
                    break;
                }
            }
            if(isConsistent){
                result.append(c);
            } else {
                break;
            }
        }
        return result.toString();
    }
}
