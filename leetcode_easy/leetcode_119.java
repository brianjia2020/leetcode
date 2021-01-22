package leetcode_easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_119 {

    @Test
    public void test(){
        List<Integer> row = getRow(4);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex){
        List<Integer> list1 = new ArrayList<>();
        if(rowIndex==0) {
            list1.add(1);
            return list1;
        }
        if(rowIndex==1){
            list1.add(1);
            list1.add(1);
            return list1;
        }

        List<Integer> list2 = getRow(rowIndex - 1);
        list1.add(1);
        for(int i=1;i<list2.size();i++){
            list1.add(list2.get(i)+list2.get(i-1));
        }
        list1.add(1);
        return list1;

    }
}
