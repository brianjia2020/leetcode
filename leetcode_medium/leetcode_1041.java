package leetcode_medium;

public class leetcode_1041 {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = 1; // Initially face North.

        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);

            if (instruction == 'G') {
                x = x + dx;
                y = y + dy;
            } else if (instruction == 'L') {
                int tmp = dy;
                dy = dx;
                dx = -tmp;
            } else if (instruction == 'R') {
                int tmp = dx;
                dx = dy;
                dy = -tmp;
            }
        }
        return (x == 0 && y == 0) || dy != 1;
    }
}
