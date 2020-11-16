package leetcode_medium;

public class leetcode_34 {

    public int[] searchRange(int[] nums, int target){
        if (nums.length == 0 || nums == null) return new int[]{-1,-1};
        if (nums[0] > target) return new int[]{-1,-1};
        if (nums[nums.length-1] < target) return new int[]{-1,-1};

        int[] answer = new int[2];
        answer[0] = findPosition(nums,target,"L");
        answer[1] = findPosition(nums,target,"R");
        return answer;
    }

    public int findPosition(int[] nums,int target, String dir){
        int pos = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) /2;
            if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                pos = mid;
                if ("R".equals(dir)){
                    start = mid + 1;
                } else if ("L".equals(dir)){
                    end = mid -1;
                }
            }
        }
        return pos;
    }
}
