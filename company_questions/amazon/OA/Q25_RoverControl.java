package company_questions.amazon.OA;

public class Q25_RoverControl {
    public static void main(String[] args) {
        int n =4;
        String[] commands = new String[]{"RIGHT","DOWN","LEFT","LEFT","DOWN"};
        System.out.println(roverControl(n,commands));
    }
    public static int roverControl(int n, String[] commands){
        int pos = 0;
        for(String cmd: commands){
            pos = oneMove(n,cmd,pos);
        }
        return pos;
    }

    public static int oneMove(int n, String command, int curPos){
        int x = curPos/n;
        int y = curPos%n;
        if(command.equals("RIGHT")) {
            if(y<3) {
                return ++curPos;
            }
            else return curPos;
        } else if (command.equals("LEFT")){
            if(y>0) return --curPos;
            else return curPos;
        } else if(command.equals("UP")){
            if(x>0) {
                curPos -= 4;
            }
            return curPos;
        } else {
            curPos += 4;
            return curPos;
        }
    }
}
