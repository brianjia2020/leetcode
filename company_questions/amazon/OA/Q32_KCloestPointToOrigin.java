package company_questions.amazon.OA;

import java.util.Arrays;

public class Q32_KCloestPointToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        if(points==null||points.length==0||K==0) return new int[][]{{}};
        int[][] res = new int[K][2];
        Arrays.sort(points,(o1, o2)->(o1[0]*o1[0]+o1[1]*o1[1]-o2[0]*o2[0]-o2[1]*o2[1]));
        for(int i=0;i<K;i++){
            res[i] = points[i];
        }
        return res;
    }
}
