package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals,(int[]a,int[]b)->(a[0]-b[0]));
        Queue<Integer> minHeap = new PriorityQueue<>((a,b)->(a-b));
        minHeap.add(intervals[0][1]);

        for(int i = 1; i<intervals.length;i++){
            if(intervals[i][0] >= minHeap.peek() ){
                minHeap.poll();
            }
            minHeap.add(intervals[i][0]);
        }
        return minHeap.size();
    }
}
