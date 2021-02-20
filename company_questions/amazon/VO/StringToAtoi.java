package company_questions.amazon.VO;

public class StringToAtoi {
    public int myAtoi(String s){
        //edge case:
        if(s==null) return 0;
        s = s.trim();
        long res = 0;
        int sign = 1;
        int index = 0;
        if(s.charAt(index)=='-'){
            sign = -1;
            index++;
        } else if (s.charAt(index)=='+'){
            sign = 1;
            index++;
        }

        while(index<s.length()){
            if(Character.isDigit(s.charAt(index))){
                res = res*10 + (s.charAt(index)-'0');
                if (sign==1&&res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
                else if (sign==-1&&(-1)*res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                return (int) res*sign;
            }
            index++;
        }
        return (int) res*sign;

    }
}
