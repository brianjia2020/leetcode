package company_questions.amazon;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q38_DiskSpaceAnalysis {
    public static void main(String[] args) {
        int numComputers = 3;
        int[] hardDiskSpace = new int[]{8,2,4};
        int segmentLength = 2;
        System.out.println(getDiskSpaceAnalysis(numComputers,hardDiskSpace,segmentLength));
    }
    public static int getDiskSpaceAnalysis(int numOfComputers, int[] hardDiskSpace, int segmentLength){
        int ans = -1;
        Queue<Integer> queue2 = new PriorityQueue<>();
        for(int i=0;i<segmentLength;i++) queue2.add(hardDiskSpace[i]);
        for(int i=0;i<=numOfComputers-segmentLength;i++){
            int curMin = queue2.peek();
            ans = Math.max(ans,curMin);
            queue2.remove(hardDiskSpace[i]);
            if(i+segmentLength<numOfComputers) {
                queue2.add(hardDiskSpace[i + segmentLength]);
            } else break;
        }
        return ans;
    }
}
