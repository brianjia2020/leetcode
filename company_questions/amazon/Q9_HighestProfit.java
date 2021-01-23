package company_questions.amazon;

import java.util.*;

public class Q9_HighestProfit {
    public static void main(String[] args) {
        System.out.println(supplierInventory2(2,new long[]{3,5},6));
    }

    //optimized using TreeMap with comparator to keep it in order
    public static long supplierInventory2(int suppliers, long[] inventory, long order){
        Map<Integer,Integer> map = new TreeMap<>((o1,o2)->(o2-o1));
        for(int i=0;i<inventory.length;i++){
            for(int j=1;j<=inventory[i];j++){
                if(!map.containsKey(j)) map.put(j,1);
                else {
                    map.put(j,map.get(j)+1);
                }
            }
        }
        System.out.println(map);
        int profit = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>=order) {
                profit += order*entry.getKey();
                break;
            }
            else {
                profit += entry.getKey()*entry.getValue();
                order -= entry.getValue();
            }
        }
        return profit;
    }

    //time limit exceeds
    public static long supplierInventory(int suppliers, long[] inventory,long order){
        Queue<Long> queue = new PriorityQueue<>((o1,o2)-> (int) (o2-o1));
        for(long num: inventory) queue.add(num);
        int profit = 0;
        while(order>0&&!queue.isEmpty()){
            long temp = queue.poll();
            profit += temp;
            temp--;
            if(temp!=0) queue.add(temp);
            order--;
        }
        return profit;
    }
}
