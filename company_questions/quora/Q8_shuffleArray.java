package company_questions.quora;

import org.junit.Test;

import java.util.*;

public class Q8_shuffleArray {
    @Test
    public void test(){
        int[] arr = new int[]{91,4,64,78};
        int[][] arr2 = {{78},{4,64},{91}};
        System.out.println(shuffleArray(arr,arr2));
    }
    //similar to leetcode_1640
    public boolean shuffleArray(int[] arr, int[][]pieces){
        int n = arr.length;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0;i<pieces.length;i++){
            map.put(pieces[i][0],pieces[i]);
        }
//        Set<Integer> set = new HashSet<>();
        int i =0;
        while(i<n){
            if(map.containsKey(arr[i])){
//                set.add(arr[i]);
                int[] temp = map.get(arr[i]);
//                System.out.println(Arrays.toString(temp));
                for(int j=0;j<temp.length;j++){
//                    System.out.println(arr[i]);
//                    System.out.println(temp[j]);
                    if(arr[i]!=temp[j]) {
                        return false;
                    }
                    i++;
//                    System.out.println(i);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
