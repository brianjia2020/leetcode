package company_questions.amazon;

import java.util.ArrayList;
import java.util.List;

public class Q18_CriticalConnection {
    public static void main(String[] args) {
        int n =4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<>());
        connections.get(0).add(0);
        connections.get(0).add(1);
        connections.add(new ArrayList<>());
        connections.get(1).add(1);
        connections.get(1).add(2);
        connections.add(new ArrayList<>());
        connections.get(2).add(2);
        connections.get(2).add(0);
        connections.add(new ArrayList<>());
        connections.get(3).add(1);
        connections.get(3).add(3);
        System.out.println(criticalConnections(n,connections));
    }

    static List<List<Integer>> result;
    static int time;
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] low = new int[n];
        int[] discovery = new int[n];
        result = new ArrayList<>();
        time = 0;
        List<Integer> map[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            map[i] = new ArrayList<>();
        }
        for(List<Integer> connection: connections){
            map[connection.get(0)].add(connection.get(1));
            map[connection.get(1)].add(connection.get(0));
        }
        tarjan_bridge(0,map,low,discovery,-1);
        return result;
    }

    public static void tarjan_bridge(int src,List<Integer> map[],int[] low, int[] discovery,int par){
        discovery[src] = low[src] = time++;
        for(int child: map[src]){
            if(child==par) continue;
            if(discovery[child]==0){
                tarjan_bridge(child,map,low,discovery,src);
                if(low[child]>discovery[src]){
                    result.add(List.of(child,src));
                } else {
                    low[src] = Math.min(low[src],low[child]);
                }
            } else {
                low[src] = Math.min(low[src],low[child]);
            }
        }
    }
}
