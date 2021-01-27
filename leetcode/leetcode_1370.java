package leetcode;

public class leetcode_1370 {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
    }

    public static String sortString(String s){
        StringBuilder res = new StringBuilder(s.length());
        int [] lettercount = new int[26];
        int sLength = s.length();

        //populate letter count array
        for(char c: s.toCharArray()){
            lettercount[c - 'a']++;
            //System.out.println(Arrays.toString(lettercount));
        }

        while (sLength != 0){
            for(int i = 0;i < lettercount.length; i++){
                if(lettercount[i] != 0)
                {
                    char c = (char) ('a' + i);
                    res.append(c);
                    lettercount[i]--;
                    sLength--;
                }
            }

            for(int i=lettercount.length-1; i>=0; i--)
            {
                if(lettercount[i] != 0)
                {
                    char c = (char) ('a' + i);
                    res.append(c);
                    lettercount[i]--;
                    sLength--;
                }
            }
        }
        return res.toString();
    }
}
