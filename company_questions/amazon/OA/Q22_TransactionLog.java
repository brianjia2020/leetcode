package company_questions.amazon.OA;

import java.util.*;

public class Q22_TransactionLog {
    public static void main(String[] args) {
        int threshold = 3;
        List<String> logs = new ArrayList<>();
        logs.add("345366 89921 45");
        logs.add("029323 38239 23");
        logs.add("38239 345366 15");
        logs.add("029323 38239 77");
        logs.add("345366 38239 23");
        logs.add("029323 345366 13");
        logs.add("38239 38239 23");
        System.out.println(getTransactionLogs(3,logs));
    }
    public static List<String> getTransactionLogs(int threshold, List<String> logs){
        Map<String,Integer> map = new HashMap<>();
        Set<String> res = new HashSet<>();
        for(String log: logs){
            String[] record = log.split(" ");
            map.putIfAbsent(record[0],0);
            map.putIfAbsent(record[1],0);
            if(map.get(record[0])>=2) res.add(record[0]);
            if(map.get(record[0])>=2) res.add(record[1]);
            if(record[0].equals(record[1])){
                map.put(record[0],map.get(record[0])+1);
            } else {
                map.put(record[0],map.get(record[0])+1);
                map.put(record[1],map.get(record[1])+1);
            }
        }

        List<String> res2 = new ArrayList<>(res);
        res2.sort((o1,o2)->(Integer.compare(Integer.parseInt(o2),Integer.parseInt(o1))));
        return res2;
    }
}
