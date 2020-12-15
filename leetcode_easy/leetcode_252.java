package leetcode_easy;

import java.util.Arrays;

public class leetcode_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) return true;
        Arrays.sort(intervals,(int[]a,int[]b)->(a[0]-b[0]));
        for(int i =1;i<intervals.length;i++){
            int curStart = intervals[i][0];
            int preEnd = intervals[i-1][1];
            if (curStart < preEnd) return false;
        }
        return true;
    }
}
