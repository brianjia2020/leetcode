package leetcode;

public class leetcode_1266 {
    public static void main(String[] args) {

    }

    public static int run(int [][] points){
        int start_x = 0;
        int start_y = 0;
        int steps = 0;
        for(int i =0;i<points.length-1;i++){
            start_x = points[i][0];
            start_y = points[i][1];
            steps += getSteps(start_x,points[i+1][0],start_y,points[i+1][1]);
        }
        return steps;
    }

    public static int getSteps(int x1,int x2, int y1, int y2){
        int steps = 0;
        int steps_x = Math.abs(x1-x2);
        int steps_y = Math.abs(y1-y2);
        if (steps_x >= steps_y){
            steps = steps_x;
        } else {
            steps = steps_y;
        }
        return steps;
    }
}
