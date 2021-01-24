package company_questions.amazon;

import java.util.*;

public class Q26_TurnStile {

    public static void main(String[] args) {
        int[] ans = getTime(new int[]{0,0,1,5}, new int[]{0,1,1,0});
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] getTime(int[] times,int[] directions){
        int n = times.length;
        Map<Integer,List<Integer>> entryMap = new HashMap<>();
        Map<Integer,List<Integer>> exitMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(directions[i]==0){
                List<Integer> list = entryMap.getOrDefault(times[i],new ArrayList<>());
                list.add(i);
                entryMap.put(times[i],list);
            } else {
                List<Integer> list = exitMap.getOrDefault(times[i], new ArrayList<>());
                list.add(i);
                exitMap.put(times[i],list);
            }
            if(max<times[i]) max=times[i];
            if(min>times[i]) min=times[i];
        }
        int t=1;
        int[] res=new int[n];
        int time = min;
        while(entryMap.keySet().size()>0||exitMap.keySet().size()>0){
            int j=min;
            if(t==1){
                if(exitMap.keySet().size()>0){
                    while(!exitMap.containsKey(j)&&j<time){
                        j += 1;
                    }
                    if(exitMap.containsKey(j)){
                        int k = exitMap.get(j).get(0);
                        res[k] = time;
                        exitMap.get(j).remove(0);
                        t=1;
                        if(exitMap.get(j).size()==0) exitMap.remove(j);
                    }
                } else if(entryMap.keySet().size()>0){
                    while(!entryMap.containsKey(j)&&j<time){
                        j+=1;
                    }
                    if(entryMap.containsKey(j)){
                        int k = entryMap.get(j).get(0);
                        res[k] = time;
                        entryMap.get(j).remove(0);
                        t=0;
                        if(entryMap.get(j).size()==0) entryMap.remove(j);
                    }
                }
            } else {
                if(entryMap.keySet().size()>0){
                    while(!entryMap.containsKey(j)&&j<time) j+=1;
                    if(entryMap.containsKey(j)){
                        int k = entryMap.get(j).get(0);
                        res[k] = time;
                        entryMap.get(j).remove(0);
                        t=0;
                        if(entryMap.get(j).size()==0) entryMap.remove(j);
                    }
                } else if(exitMap.keySet().size()>0){
                    while(!exitMap.containsKey(j)&&j<time) j+=1;
                    if(exitMap.containsKey(j)){
                        int k = exitMap.get(j).get(0);
                        res[k] = time;
                        t=1;
                        exitMap.get(j).remove(0);
                        if(exitMap.get(j).size()==0) exitMap.remove(j);
                    }
                }
            }
            time++;
        }
        return res;
    }
}
