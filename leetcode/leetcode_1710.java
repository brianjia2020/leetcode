package leetcode;

import java.util.Arrays;

public class leetcode_1710 {
    public static void main(String[] args) {
        int[][] nums = {{5,10},{2,5},{4,7},{3,9}};
        System.out.println(maximumUnits(nums,10));
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(o1,o2)->(o2[1]-o1[1]));
        int unitCount = 0;
        int i = 0;
        while(truckSize>0&&i<boxTypes.length){
            if(boxTypes[i][0]<=truckSize){
                truckSize -= boxTypes[i][0];
                unitCount += boxTypes[i][1]*boxTypes[i][0];
            } else {
                unitCount += boxTypes[i][1]*truckSize;
                truckSize = 0;
            }
            i++;
        }
        return unitCount;
    }
}
