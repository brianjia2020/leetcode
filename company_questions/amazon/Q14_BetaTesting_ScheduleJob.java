package company_questions.amazon;

import java.util.Arrays;

public class Q14_BetaTesting_ScheduleJob {
    static int[][] mem;

    public static void main(String[] args) {
        int[] jobDifficulty = new int[]{6,5,4,3,2,1};
        System.out.println(minDifficulty(jobDifficulty,2));
    }
    //
    public int minDifficulty2(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) return -1;
        int[][] dp = new int[jobDifficulty.length + 1][];

        for(int i = 0; i <= jobDifficulty.length; i ++){
            dp[i] = new int[d+1];
            for(int j = 0; j <=d; j ++){
                dp[i][j] = Integer.MAX_VALUE/2;
            }
            // dp[0][0] =
        }
        dp[0][0] = 0;

        for( int i = 0; i <= jobDifficulty.length; i ++){
            for(int j = 1; j <=d; j ++){
                int maxjob = 0;
                for(int k = i-1; k >=j-1; k--){
                    maxjob = Math.max(maxjob, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[k][j-1] + maxjob);
                }
            }
        }

        return dp[jobDifficulty.length][d];
    }
    public static int minDifficulty(int[] jobDifficulty,int d){
        int n = jobDifficulty.length;
        if(n<d) return -1;
        mem = new int[n][d];
        for(int[] subList: mem) Arrays.fill(subList,-1);
        dfs(jobDifficulty,0,d);
        return mem[0][d-1];
    }
    public static void dfs(int[] jobDifficulty, int start, int d){
        int n = jobDifficulty.length;

        int curDiff = 0;
        int minDiff = Integer.MAX_VALUE;
        if(d==1){
            for(int i=start;i<n;i++){
                curDiff = Math.max(jobDifficulty[i],curDiff);
            }
            minDiff = curDiff;
        } else {
            for(int i=start;n-1-i>=d-1;i++){
                curDiff = Math.max(curDiff,jobDifficulty[i]);
                if(mem[i+1][d-2]==-1) dfs(jobDifficulty,i+1,d-1);
                int remain = mem[i+1][d-2];
                if(remain==-1) break;
                minDiff = Math.min(minDiff,curDiff+remain);
            }
        }
        mem[start][d-1] = minDiff;
    }
}
