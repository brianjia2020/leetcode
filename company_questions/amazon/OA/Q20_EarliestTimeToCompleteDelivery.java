package company_questions.amazon.OA;

import java.util.*;

public class Q20_EarliestTimeToCompleteDelivery {


    public static int findEarliestTime(int numOfBuilding,int[] buildingOpenTime,int[] offloadTime) {
        Arrays.sort(buildingOpenTime);
        Arrays.sort(offloadTime);

        int ans = 0;
        for(int i = 0; i < offloadTime.length; i+= 4) {
            ans = Math.max(ans, buildingOpenTime[buildingOpenTime.length - i/4 -1] + offloadTime[i+3]);
        }

        return ans;
    }
}
