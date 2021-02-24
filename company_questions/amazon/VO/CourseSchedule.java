package company_questions.amazon.VO;

import java.util.*;

public class CourseSchedule {
    //Leetcode 207. Course Schedule
    //Leetcode 210. Course Schedule II, just add a int[] res to record the courses taken in the
    //queue loop
    public boolean canFinish(int numCourses, int[][] prerequisites){
        //edge cases:
        if(numCourses<=1||prerequisites==null||prerequisites.length==0) return true;

        //solution:
        //3.[[0,1],[1,0],[1,2]]
        //inDegree array to record how many requirements
        //Map<Integer,List<Integer>> map to record how many prerequisite courses for each course
        //BFS to update inDegree[i] = 0 courses and update the map
        //eventually if inDegree[i] all are 0, then finished
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] requirement: prerequisites){
            inDegrees[requirement[0]]++;
            if(map.containsKey(requirement[1])){
                map.get(requirement[1]).add(requirement[0]);
            } else {
                List<Integer> tempList = new LinkedList<>();
                tempList.add(requirement[0]);
                map.put(requirement[1],tempList);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegrees.length;i++) {
            if(inDegrees[i]==0) queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            Integer curCourse = queue.poll();
            count++;
            List<Integer> requirements = map.get(curCourse);
            for(int i=0;requirements!=null&&i<requirements.size();i++){
                inDegrees[requirements.get(i)]--;
                if(inDegrees[requirements.get(i)]==0) queue.add(requirements.get(i));
            }
        }
        return count==numCourses;
    }
}
