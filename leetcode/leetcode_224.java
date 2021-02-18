package leetcode;

public class leetcode_224 {

    public static void main(String[] args) {
        String s = "2 - 1 + 2";
        System.out.println(new leetcode_224().calculate1(s));
    }

    //solution 1: only consider simple expressions with numbers and -,+
    public int calculate1(String s){
        int res = 0;
        char sign = '+';
        int temp = 0;
        s = s.replace(" ","");
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                temp += temp*10+(c-'0');
            } else {
                if(sign=='+'){
                    res += temp;
                } else {
                    res -= temp;
                }
                temp =0;
                sign=c;
            }
        }
        return sign=='+'?res+temp:res-temp;
    }


    //solution 2: now consider expressions with ()
    //      will need to use recursion or stack for this
    int index = 0;
    public int calculate2(String s){
        //edge cases:
        if(s==null||s.length()==0) return 0;
        s = s.replaceAll(" ","");
        return get(s);
    }

    public int get(String s){
        if(index>=s.length()) return 0;
        int res = 0;
        char sign = '+';
        while(index<s.length()){
            int cur = 0;
            if(s.charAt(index)=='('){
                index++;
                cur = get(s);
            } else {
                while(index<s.length()&&Character.isDigit(s.charAt(index))){
                    cur = cur*10+(s.charAt(index)-'0');
                    index++;
                }
            }

            if(sign=='+') res += cur;
            else if(sign=='-') res -= cur;

            if(index<s.length()&&s.charAt(index)==')'){
                index++;
                break;
            }

            if(index<s.length()){
                sign = s.charAt(index);
            }
        }
        return res;
    }
}
