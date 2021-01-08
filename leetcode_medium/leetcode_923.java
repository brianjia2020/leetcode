package leetcode_medium;

import org.junit.Test;

import java.util.*;

public class leetcode_923 {
    @Test
    public void test(){
        int[] A = new int[]{92,4,59,23,100,16,7,15,3,78,98,17,77,33,83,15,87,35,54,72,58,14,87,47,58,31,72,58,87,22,25,54,27,53,13,54,61,12,96,24,35,43,94,1,88,76,89,89,41,56,61,65,60,91,89,79,86,52,27,2,97,46,50,46,87,93,71,87,95,78,65,10,35,51,34,66,61,7,49,38,10,1,88,37,50,84,35,20,7,83,51,85,11,12,89,93,54,23,36,95,100,19,82,67,96,77,53,56,51,16,54,7,30,68,78,13,38,52,91,44,54,17,21,44,4,10,85,19,11,88,73,36,47,53,3,21,41,24,60,53,88,35,48,89,35,3,43,85,45,67,56,78,44,49,29,35,68,96,29,21,51,17,52,99,3,48,65,51,22,38,77,81,30,64,99,35,88,72,73,29,29,2};
        int i = threeSumMulti(A, 105);
        System.out.println("Result: " + i);
    }

    private static final int MOD=(int) 1e9 + 7;
    private static final int MAX_VALUE = 100;
    public int threeSumMulti2(int[] A, int target){
        int n = A.length;
        long answer = 0;
        int[] arr = new int[MAX_VALUE+1];
        for(int i = 1;i<n-1;i++){
            Arrays.fill(arr,0);
            for(int j=0;j<i;j++){
                arr[A[i]]++;
            }
            for(int k=i+1;k<n;k++){
                int rest = target - A[k] - A[i];
                if(rest>=0 && rest <= MAX_VALUE){
                    answer += arr[rest];
                }
            }
        }
        return (int) answer%MOD;
    }

    public int threeSumMulti(int[] A, int target){
        if(A.length < 3 || A[0]>target) return 0;
        int count = 0;
        int max=100;
        int kMod = (int) (1e9+7);
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : A) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();
        for(int i: set){
            for(int j: set){
                int k = target - i - j;
                if(k<0||k>=max||!set.contains(k)) continue;
                if(i<=j&&j<=k) {
                    if(i==j&&j==k&&map.get(i)>=3) {
                        long count2 = map.get(i);
                        count2 = count + (count2 - 2) *(count2-1)*count2/6;
                        count = (int) (((count2%kMod)+count)%kMod);
                    } else if (i==j && j!=k && map.get(i)>=2){
                        count += map.get(k)*(map.get(i)-1)*map.get(i)/2;
                    } else if (i!=k&&j==k&&map.get(j)>=2){
                        count += map.get(i) * (map.get(j)-1)*(map.get(j))/2;
                    } else if (i!=j&&j!=k){
                        count += map.get(i)*map.get(j)*map.get(k);
                    }
                    System.out.println(map);
                    System.out.println(i+" "+j+" "+k);
                    System.out.println(count);
                }
            }
        }
        return count;
    }
}
