package company_questions.amazon.OA;

import java.util.*;

public class Q27_LargestItemAssociation {

    public static void main(String[] args) {
        List<PairString> itemAssociation = new ArrayList<>();
        itemAssociation.add(new PairString("item1","item2"));
        itemAssociation.add(new PairString("item3","item4"));
        itemAssociation.add(new PairString("item4","item5"));
        System.out.println(LargestItemAssociation(itemAssociation));
    }

    //iterative, if TLE, use the second methods
    public static List<String> LargestItemAssociation(List<PairString> itemAssociation){
        Queue<TreeSet<String>> queue = new PriorityQueue<>((o1,o2)->{
            if(o2.size()==o1.size()) return o1.first().compareTo(o2.first());
            else return o2.size()-o1.size();
        });

        for(PairString pairString: itemAssociation){
            boolean flag = false;
            for(TreeSet<String> set1: queue){
                if(set1.contains(pairString.first)) {
                    set1.add(pairString.first);
                    set1.add(pairString.second);
                    //update the queue
                    if(set1.size()>=queue.peek().size()){
                        queue.remove(set1);
                        queue.add(set1);
                    }
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                TreeSet<String> set = new TreeSet<>((o1,o2)->(o1.compareTo(o2)));
                set.add(pairString.first);
                set.add(pairString.second);
                queue.add(set);
            }
        }

        if(queue.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(queue.peek());
    }

    static class PairString{
        String first;
        String second;
        public PairString(String first,String second){
            this.first = first;
            this.second = second;
        }
    }


    //DFS starts here
    static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        LinkedHashMap<String, LinkedHashSet<String>> map = new LinkedHashMap<>();
        for (PairString pairs : itemAssociation) {
            if (pairs.first.equals(pairs.second)) continue;
            map.computeIfAbsent(pairs.first, val -> new LinkedHashSet<>()).add(pairs.second);
            map.computeIfAbsent(pairs.second, val -> new LinkedHashSet<>()).add(pairs.first);
        }
        List<String> result = new ArrayList<>();
        for (String name : map.keySet()) {
            Set<String> visited = new HashSet<>();
            List<String> cur = dfs(name, map, visited);
            if (cur.size() > result.size()) {
                result = cur;
            }
        }
        return result;
    }

    private static List<String> dfs(String name, Map<String, LinkedHashSet<String>> map, Set<String> visited) {
        if (!visited.add(name)) return new ArrayList<>();
        List<String> cur = new ArrayList<>();
        for (String dep : map.get(name)) {
            List<String> next = dfs(dep, map, visited);
            if (next.size() > cur.size()) {
                cur = next;
            }
        }
        visited.remove(name);
        cur.add(0, name);
        return cur;
    }
}
