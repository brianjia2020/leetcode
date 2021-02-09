package company_questions.amazon.OA;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q16_ChooseAFlask {
    public static void main(String[] args) {
        int numOfOrder = 4;
        int[] requirements = new int[]{4,6,6,7};
        int flaskType =3;
        int totalMarks=9;
        int[][] markings=new int[][]{{0,3},{0,5},{0,7},{1,6},{1,8},{1,9},{2,3},{2,5},{2,6}};
        System.out.println(chooseAFlask(numOfOrder,requirements,flaskType,totalMarks,markings));
    }

    public static int chooseAFlask(int numOfOrder,int[] requirements,int flaskTypes,int totalMarks,int[][] markings){
        int bestType = -1;
        int bestLoss = Integer.MAX_VALUE;
        boolean canOffer = true;
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for(int[] marking:markings){
            map.putIfAbsent(marking[0],new TreeSet<>());
            map.get(marking[0]).add(marking[1]);
        }
        System.out.println(map);
        //loop over each type, then compare the loss
        for(int i=0;i<flaskTypes;i++){
            int curLoss = 0;
            for(int j=0;j<numOfOrder;j++){
                if (map.get(i).contains(requirements[j])) continue;
                Integer offering = map.get(i).higher(requirements[j]);
                if(offering==null) {
                    canOffer = false;
                }
                else curLoss += (offering-requirements[j]);
            }
            if(canOffer){
                if(curLoss<bestLoss){
                    bestLoss = curLoss;
                    bestType = i;
                }
            }

        }
        return bestType;
    }


}
