package leetcode;

import java.util.*;

public class leetcode_207 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0}};
        leetcode_207 instance = new leetcode_207();
        System.out.println(instance.canFinish(2,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites){
        int[] inDegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] prerequisite: prerequisites){
            inDegree[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        System.out.println(map);
        System.out.println(Arrays.toString(inDegree));

        //using a queue to always add courses with inDegree as 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            Integer course = queue.poll();
            List<Integer> dependencies = map.get(course);
            if(dependencies!=null) {
                for (int num : dependencies) {
                    inDegree[num]--;
                    if(inDegree[num]==0) queue.add(num);
                }
            }
        }

        for(int num: inDegree){
            if(num!=0) return false;
        }
        return true;
    }


}
