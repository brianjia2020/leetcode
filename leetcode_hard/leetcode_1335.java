package leetcode_hard;

import java.util.Arrays;

public class leetcode_1335 {
    int[][] memoization;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return - 1;

        memoization = new int[n][d];
        for (int[] arr: memoization)// initialize memo with -1 to distinguish from difficulties >= 0
            Arrays.fill(arr, -1);

        dfs(jobDifficulty, 0, d);

        return memoization[0][d - 1];
    }

    public void dfs(int[] arr, int start, int d) {
        int n = arr.length;

        int curDiff = 0;// current day difficulty
        int minDiff = Integer.MAX_VALUE;

        if (d == 1) {// last day
            for (int i = start; i < n; i ++)
                curDiff = Math.max(curDiff, arr[i]);
            minDiff = curDiff;
        } else {// keep search down
            for (int i = start; n - 1 - i >= d - 1; i ++) {
                curDiff = Math.max(curDiff, arr[i]);

                if (memoization[i + 1][d - 2] == -1)
                    dfs(arr, i + 1, d - 1);

                int remain =  memoization[i + 1][d - 2];

                if (remain == -1) break;

                minDiff = Math.min(minDiff, curDiff + remain);
            }
        }

        memoization[start][d - 1] = minDiff;
    }
}
