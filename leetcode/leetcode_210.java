package leetcode;

import java.util.*;

public class leetcode_210 {
    public int[] canFinish(int numCourses, int[][] prerequisites){
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] prerequisite: prerequisites){
            inDegree[prerequisite[0]]++;
            map.putIfAbsent(prerequisite[1], new ArrayList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        //using a queue to always add courses with inDegree as 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        int j = 0;
        while(!queue.isEmpty()){
            Integer course = queue.poll();
            res[j] = course;
            j++;
            List<Integer> dependencies = map.get(course);
            if(dependencies!=null) {
                for (int num : dependencies) {
                    inDegree[num]--;
                    if(inDegree[num]==0) queue.add(num);
                }
            }
        }

        for(int num: inDegree){
            if(num!=0) return new int[]{};
        }
        return res;
    }
}
