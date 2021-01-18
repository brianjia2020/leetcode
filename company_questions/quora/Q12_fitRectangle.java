package company_questions.quora;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q12_fitRectangle {
    @Test
    public void test(){
        int[][] res = new int[][] {{0,1,3},{0,4,2},{1,3,4},{1,3,2}};
        boolean[] booleans = fitRectangle(res);
        System.out.println(Arrays.toString(booleans));
    }

    public boolean[] fitRectangle(int[][] ops){
        List<Boolean> res = new ArrayList<>();
        List<int[]> rectangles = new ArrayList<>();
        for (int[] op : ops) {
            if (op[0] == 0) {
                rectangles.add(new int[]{op[1], op[2]});
            } else {
                res.add(ifTwoRectanglesFit(rectangles, new int[]{op[1], op[2]}));
            }
        }
        boolean[] res1 = new boolean[res.size()];
        for(int i = 0;i<res.size();i++){
            res1[i] = res.get(i);
        }
        return res1;
    }

    public boolean ifTwoRectanglesFit(List<int[]> rectangles, int[] rectangle){
        for(int[] num: rectangles){
            if(rectangle[0]>=num[0]&&rectangle[1]>=num[1]) continue;
            if(rectangle[1]>=num[0]&&rectangle[0]>=num[1]) continue;
            return false;
        }
        return true;
    }


}
