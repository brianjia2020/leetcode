package leetcode;

import org.junit.Test;

public class leetcode_657 {
    @Test
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char input: moves.toCharArray()){
            if (input == 'U'){
                y++;
            } else if (input == 'D'){
                y--;
            } else if (input == 'L'){
                x--;
            } else if (input == 'R'){
                x++;
            }
        }
        return x == 0 && y == 0;
    }
}
