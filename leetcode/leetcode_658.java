package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr==null||arr.length==0) return res;
        int Pos = findPos(arr,x,0,arr.length-1);
        // if(k>0){
        //     res.add(arr[Pos]);
        //     k--;
        // }
        int left = Pos-1;
        int right = Pos;
        System.out.println(Pos);
        while(k>0&&left>=0&&right<arr.length){
            if(Math.abs(arr[left]-x)<=Math.abs(arr[right]-x)){
                res.add(0,arr[left]);
                left--;
            }
            else {
                res.add(arr[right]);
                right++;
            }
            k--;
        }

        while(k>0&&left>=0){
            res.add(0,arr[left]);
            left--;
            k--;
        }

        while(k>0&&right<arr.length){
            res.add(arr[right]);
            right++;
            k--;
        }
        return res;


    }

    public int findPos(int[] arr, int x, int left, int right){
        if(left>right) return left;
        int mid = left + (right-left)/2;
        if(arr[mid] == x) {
            return mid;
        } else if (arr[mid]>x){
            return findPos(arr,x,left,mid-1);
        } else {
            return findPos(arr,x,mid+1,right);
        }

    }
}
