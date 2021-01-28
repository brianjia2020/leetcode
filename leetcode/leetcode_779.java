package leetcode;

public class leetcode_779 {

    public static void main(String[] args) {
        System.out.println(KthGrammar2(4,5));
    }

    //1. brute force.......O(2^n)
    public int KthGrammar(int N, int K){
        String s = dfs(N);
        return s.charAt(K-1)=='0'?0:1;
    }

    public String dfs(int N){
        if(N==1) return "0";
        String previousRow = dfs(N-1);
        StringBuilder s= new StringBuilder();
        for(int i=0;i<previousRow.length();i++){
            if(previousRow.charAt(i)=='0') s.append("01");
            else s.append("10");
        }
        return s.toString();
    }

    //2.
    public static int KthGrammar2(int N, int K){
        if(N==1) return 0;
        if(N==2&&K==1) return 0;
        if(N==2&&K==2) return 1;
        if(K%2==1) K++;
        return KthGrammar2(N-1, K/2)==1?0:1;
    }

}
