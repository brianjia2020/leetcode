package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode_84 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(LargestRectangleArea(arr));
    }


    public static int LargestRectangleArea2(int[] heights){
        int len = heights.length;
        if(len==0) return 0;
        if(len==1) return heights[0];
        int area = 0;
        int[] newHeights = new int[len+2];
        for(int i=0;i<len;i++){
            newHeights[i+1] = heights[i];
        }
        len+=2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for(int i=0;i<len;i++){
            while(heights[stack.peekLast()]>heights[i]){
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area,height*width);
            }
            stack.addLast(i);
        }
        return area;
    }
    //brute force
    public static int LargestRectangleArea(int[] heights){
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int left = i-1;
            int right = i+1;

            while(left>=0&&heights[left]>=heights[i]){
                left--;
            }

            while(right<heights.length&&heights[right]>=heights[i]){
                right++;
            }
            maxArea = Math.max(maxArea, (right-left-1)*heights[i]);
        }
        return maxArea;
    }
}
