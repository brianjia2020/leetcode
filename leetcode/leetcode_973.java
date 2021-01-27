package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class leetcode_973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        Arrays.sort(points,(a,b) -> (int) Math.sqrt(a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]));
        System.out.println(Arrays.deepToString(points));
        for(int i=points.length-1;i>points.length-K-1;i--){
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
}
