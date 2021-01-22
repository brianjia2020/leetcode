package company_questions.amazon;

import java.util.*;

public class Q3_ConnectedSum {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = new int[][]{{1,2},{1,3},{2,4},{3,5},{7,8}};
        System.out.println(getConnectedSum(n,edges));
    }

    public static int getConnectedSum(int n,int[][] edges){
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++) map.put(i,new ArrayList<>());
        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n+1];
        int res = 0;
        for(int i =1;i<=n;i++){
            TreeSet<Integer> tree = new TreeSet<>();
            if(!visited[i]){
                visited[i]=true;
                dfs(map,visited,i,tree);
            }
            if(tree.isEmpty()) continue;
            System.out.println(tree);
            res += Math.sqrt(tree.size()==1?1:tree.last()+0.0);
        }
        return res;
    }

    public static void dfs(Map<Integer,List<Integer>> map,boolean[] visited,int cur, TreeSet<Integer> tree){
        tree.add(cur);
        for(int nei: map.get(cur)){
            if(!visited[nei]){
                visited[nei] = true;
                dfs(map,visited,nei,tree);
            }
        }
    }
}
