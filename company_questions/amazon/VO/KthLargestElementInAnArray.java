package company_questions.amazon.VO;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0||nums.length<k) return 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num: nums){
            queue.offer(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
        int left = 0;
        int right = nums.length-1;
        while(true){
            int pos = position(nums,left,right);
            if(pos+1==k){
                return nums[pos];
            } else if(pos+1>k){
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int position(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while(l<=r){
            if(nums[l]<pivot&&nums[r]>pivot){
                swap(nums,l,r);
                l++;
                r--;
            }
            if(nums[l]>=pivot) l++;
            if(nums[r]<=pivot) r--;
        }
        swap(nums,left,r);
        return r;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
