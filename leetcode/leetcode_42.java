package leetcode;

public class leetcode_42 {
    //1. brute force
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0;i<height.length;i++){
            int left_max = height[i];
            int right_max = height[i];
            for (int j =i; j>=0;j--){
                if (left_max < height[j]){
                    left_max = height[j];
                }
            }

            for (int j =i; j<height.length;j++){
                if (right_max < height[j]){
                    right_max = height[j];
                }
            }
            sum += Math.min(right_max,left_max) - height[i];
        }
        return sum;
    }

    //2. dp
    public int trap2(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for(int i = 0;i<leftMax.length;i++){
            leftMax[i] = i==0?height[0]:Math.max(height[i],leftMax[i-1]);
        }
        for(int i = height.length-1;i>=0;i--){
            rightMax[i] = i==height.length-1?height[height.length-1]:Math.max(height[i],rightMax[i+1]);
        }
        int sum = 0;
        for (int i =0;i<height.length;i++){
            sum += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return sum;
    }

}
