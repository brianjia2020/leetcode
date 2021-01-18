package company_questions.quora;

import org.junit.Test;

import java.util.*;

public class Q19_matrixBeautify {
    @Test
    public void test(){
        int[][]  nums = {{1,2,2,3},{3,4,10,4},{2,10,1,2},{5,4,4,5}};
        int size = 2;
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
        System.out.println("Debug:  ");
        int[][] res = beautifyMatrix(nums, 2);
        for (int[] num : res) {
            System.out.println(Arrays.toString(num));
        }
    }

    private int[][] beautifyMatrix(int[][] nums, int size) {
        Map<Integer,List<int[][]>> map = new HashMap<>();
        List<int[]> posInfo  = new ArrayList<>();
        for(int i =0;i<nums.length;i+=size){
            for(int j=0;j<nums.length;j+=size){
                findPositive(nums,i,j,size,map);
                posInfo.add(new int []{i,j});
            }
        }
        Map<Integer,List<int[][]>> tm = new TreeMap<>(map);
        int posCount = 0;
        for (Map.Entry<Integer, List<int[][]>> entry : tm.entrySet()) {
            List<int[][]> lists = entry.getValue();
            for(int i=0;i<lists.size();i++){
                int[] pos = posInfo.get(posCount++);
                for(int row = 0;row<size;row++){
                    for(int col =0;col<size;col++){
                        nums[pos[0]+row][pos[1]+col] = lists.get(i)[row][col];
                    }
                }
            }
        }
        return nums;

    }

    public static void findPositive(int[][] nums,int pos1,int pos2, int size,Map<Integer,List<int[][]>> map){
        int[] checks = new int[size*size+1];
        int[][] subMatrix = new int[size][size];
        int count =0;
        for(int i=pos1;i<pos1+size;i++){
            for(int j=pos2;j<pos2+size;j++){
                checks[count++] = nums[i][j];
                subMatrix[i-pos1][j-pos2] = nums[i][j];
            }
        }
        Arrays.sort(checks);
        int missPos = -1;
        for(int i=1;i<checks.length;i++){
            if(checks[i]!=i) missPos = i;
        }
        if(missPos==-1) missPos = size*size+1;
        if(map.containsKey(missPos)) {
            map.get(missPos).add(subMatrix);
        } else {
            List<int[][]> list = new ArrayList<>();
            list.add(subMatrix);
            map.put(missPos,list);
        }
    }


}
