package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_56 {
    public int[][] merge(int[][] intervals) {
        if(intervals==null||intervals.length==0) return new int[][]{{}};
        Arrays.sort(intervals,(o1, o2)->(o1[0]-o2[0]));
        List<int[]> arr = new LinkedList<>();
        for(int i=0;i<intervals.length;i++){
            if(arr.size()==0||intervals[i][0] > arr.get(arr.size()-1)[1]) {
                arr.add(intervals[i]);
            } else {
                arr.get(arr.size()-1)[1] = Math.max(arr.get(arr.size()-1)[1], intervals[i][1]);
            }
        }
        return arr.toArray(new int[arr.size()][]);
    }
}
