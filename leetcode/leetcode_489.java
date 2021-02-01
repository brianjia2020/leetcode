package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leetcode_489 {

    //0,1 is to x+0, y+1. moving down
    //1,0 is to x+1, y+0, moving right
    int [][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public void cleanRoom(Robot robot){
        Set<String> visited = new HashSet<>();
        int[] pos = {0,0};
        backtrack(robot, pos, visited,0);
    }

    private void backtrack(Robot robot, int[] pos, Set<String> visited, int dir) {
        String curPos = pos[0] + "," + pos[1];
        if(visited.contains(curPos)){
            return;
        }

        visited.add(curPos);
        robot.clean();
        for(int i=0;i<4;i++){
            int newDir = (dir + i)%4;
            if(!robot.move()) {
                robot.turnRight();
                continue;
            }
            int[] newPos = {pos[0]+directions[newDir][0],pos[1]+directions[newDir][1]};
            backtrack(robot,newPos,visited,newDir);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnLeft();
        }
    }

}

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
}