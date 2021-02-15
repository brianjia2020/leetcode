package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_957 {
    public int[] prisonAfterNDays(int[] cells, int N){
        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        int count = 0;
        for(int i=0;i<N;i++){
            int[] next = nextDay(cells);
            String s = Arrays.toString(next);
            if(!set.contains(s)){
                count++;
                set.add(s);
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }

        if(hasCycle){
            N=N%count;
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    public int[] nextDay(int[] cells){
        int[] temp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            temp[i] = cells[i-1]==cells[i+1]?1:0;
        }
        return temp;
    }
}
