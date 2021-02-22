package company_questions.amazon.OOD.dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NDice {
    int n;
    Dice[] dices;
    List<List<Integer>> resAll;
    List<Integer> sum;

    public static void main(String[] args) {
        NDice nDice = new NDice(3);
        for (int i=0;i<3;i++) nDice.rollDices();
        nDice.show();
        System.out.println(nDice.getAllSum());
        System.out.println(nDice.getMedianFromAllRes());
    }

    public NDice(int n){
        this.n = n;
        dices = new Dice[n];
        Arrays.fill(dices,new Dice());
        sum = new ArrayList<>();
        resAll = new ArrayList<>();
    }

    public void rollDices(){
        int tempSum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<n;i++){
            int temp = dices[i].getRandom();
            res.add(temp);
            tempSum += temp;
        }
        sum.add(tempSum);
        resAll.add(res);
    }

    public int getAllSum(){
        int res = 0;
        for(int temp: sum) res += temp;
        return res;
    }

    public double getMedianFromAllRes(){
        List<Integer> res = new ArrayList<>();
        for(List<Integer> temp: resAll) res.addAll(temp);
        Collections.sort(res);
        int n = res.size();

        if(res.size()%2==0) return (res.get(n/2)+res.get(n/2-1))/2.0;
        else return res.get(n/2);
    }

    public void show(){
        for(List<Integer> temp: resAll){
            for(int num: temp){
                System.out.print(num+"->");
            }
            System.out.println();
        }
    }

}

class Dice {

    public Dice(){
    };

    //function to generate a random int number from 1 to 6
    public int getRandom(){
        return (int) Math.ceil(Math.random()*6);
    }


}
