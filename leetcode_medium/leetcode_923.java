package leetcode_medium;

import org.junit.Test;

import java.util.*;

public class leetcode_923 {
    @Test
    public void test(){
        int[] A = new int[]{0,0,0};
        int i = threeSum3(A, 0);
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
        long count = 0;
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
                        count = (map.get(i)-2)*(map.get(i)-1)*map.get(i)/6;
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
        return (int) (count%kMod);
    }

    public int threeSum3(int[] A, int target){
        int[] count = new int[101];
        final int MOD = 1000000007;
        for(int i=0;i<A.length;i++){
            count[A[i]]++;
        }
        System.out.println(Arrays.toString(count));
        int res = 0;
        for(int i=0;i<count.length;i++){
            int c = count[i];
//            System.out.println(c);
            if (c==0) continue;
            //three num are equal
            if(c>=3 && i*3==target){
                long num = 1l * (c - 2) * (c - 1) * c / 6;
                System.out.println(num);
                res = (int) (((num%MOD)+res)%MOD);
                System.out.println(res);
            }
            //two num, one has frequency greater than 2 and the other num freq at least 1
            if(c>=2){
                int remain = target -2*i;
                if(remain>=0 & remain<=100 && remain != i && count[remain] >0){
                    long num = 1l * c * (c-1) /2 * count[remain];
                    res = (int) (((num%MOD)+res)%MOD);
                }
            }
        }

        for(int i=0;i<count.length-2;i++){
            int ci = count[i];
            if(ci==0) continue;
            for (int j=i+1;j<count.length-1;j++){
                int cj = count[j];
                if(cj==0) continue;
                int remain = target - i - j;
                if (remain>j && remain<=100 && count[remain]>0){
                    long num = 1l* ci*cj*count[remain];
                    res = (int) (((num%MOD)+res)%MOD);
                }
            }
        }

        return res;
    }
}
