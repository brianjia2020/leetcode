package company_questions.amazon;

import java.util.*;

public class Q23_ItemInContainers {
    public static void main(String[] args) {
        String s = "*|*|*|";
        int[] start = new int[]{1};
        int[] end = new int[]{6};
        System.out.println(findItems(s,start,end));
    }
    public static int findItems(String s,int[] start,int[] end){
        int firstStop = s.indexOf('|');
        int lastStop = s.lastIndexOf('|');
        if(firstStop==-1||firstStop==lastStop) return 0;
        int res = 0;
        for(int i=firstStop+1;i<lastStop;i++){
            if(s.charAt(i)=='*'){
                for(int j=0;j<start.length;j++){
                    if(i<start[j]||i>end[j]) continue;
                    res++;
                }
            }
        }
        return res;
    }
}
