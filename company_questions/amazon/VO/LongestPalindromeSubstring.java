package company_questions.amazon.VO;

public class LongestPalindromeSubstring {


    //O(n^2)
    //scan the string s with index from 0 to s.length()-1 O(n)
    //two scenarios: if s.charAt(i) == s.charAt(j) we continue the search at i O(n)
    //               we also try s.charAt(i-1) == s.chatAt(j)
    //int maxlen,startPos;
    //j-i+1 > maxLen, we update the maxLen(j-i+1) and startPos(i)

    public String longestPalindrome(String s){
        //edge cases:
        if(s==null||s.length()<2) return s;
        int startPos=-1,maxLen=0;
        for(int index =0;index<s.length();index++){
            int len = Math.max(findPalindrome(s,index,index+1),findPalindrome(s,index,index));
            if(maxLen<len){
                maxLen = len;
                startPos = index - (len-1)/2;
            }
        }
        return s.substring(startPos,startPos+maxLen);
    }

    public int findPalindrome(String s, int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

    //O(n^2)
    //dynamic programming,
    // we can use a 2D array to store the results
    // i,j. for any substring (i)xxxx(j), dp[i][j] = s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]
    // update the maxLen and startPos on the run
    // return s.substring(startPos,maxLen+startPos)
//    public String longestPalindrome2(String s){
//        //edge cases:
//        if(s==null||s.length()<=1) return s;
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int startPos=0,maxLen=0;
//        for(int i = s.length()-1;i>=0;i--){
//            for(int j=s.length()-1;j>=i;j--){
//                dp[i][j] = i == j || s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
//
//                if(dp[i][j]&&(j-i+1)>maxLen){
//                    maxLen = j-i+1;
//                    startPos = i;
//                }
//            }
//        }
//        return s.substring(startPos,startPos+maxLen);
//    }
}
