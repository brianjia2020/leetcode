package company_questions.amazon.OA;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class Q21_PrimeAirRoute {
    public static void main(String[] args) {
        int maxDistance = 10000;
        int[][] frontRoute = new int[][]{{1,3000},{2,5000},{3,7000},{4,10000}};
        int[][] backRoute = new int[][]{{1,2000},{2,3000},{3,4000},{4,5000}};
        System.out.println(findBestRoute2(maxDistance,frontRoute,backRoute));
    }


    //time limit exceeds
    public static List<List<Integer>> findBestRoute(int maxDistance,int[][] frontRoute,int[][] backRoute){
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        for (int[] ints : frontRoute) {
            for (int[] value : backRoute) {
                int totalDistance = ints[1] + value[1];
                List<Integer> combination = new ArrayList<>();
                combination.add(ints[0]);
                combination.add(value[0]);
                map.putIfAbsent(totalDistance, new ArrayList<>());
                map.get(totalDistance).add(combination);
            }
        }
        TreeSet<Integer> set = new TreeSet<>(map.keySet());
        if(set.contains(maxDistance)) {
            return map.get(maxDistance);
        } else {
            return map.get(set.lower(maxDistance));
        }
    }

    //best solution
    public static List<List<Integer>> findBestRoute2(int maxDistance,int[][] frontRoute,int[][] backRoute){
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int minDiff = Integer.MAX_VALUE;
        int bestDistance = 0;
        for (int[] ints : frontRoute) {
            for (int[] value : backRoute) {
                int totalDistance = ints[1] + value[1];
                if (totalDistance > maxDistance) continue;
                int curDiff = maxDistance - totalDistance;
                if (curDiff <= minDiff) {
                    if (minDiff != Integer.MAX_VALUE) {
                        List<Integer> combination = new ArrayList<>();
                        combination.add(ints[0]);
                        combination.add(value[0]);
                        map.putIfAbsent(totalDistance, new ArrayList<>());
                        map.get(totalDistance).add(combination);
                    }
                    minDiff = curDiff;
                    bestDistance = totalDistance;
                }
            }
        }
        return map.get(bestDistance);
    }

    public static List<List<Integer>> getIdPairsForOptimal(List<List<Integer>> forwardList,
                                                           List<List<Integer>> backwardList, int maxDistance) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        forwardList = forwardList.stream().sorted((x1, x2) -> Integer.compare(x2.get(1), x1.get(1)))
                .collect(Collectors.toList());
        backwardList = backwardList.stream().sorted((x1, x2) -> Integer.compare(x1.get(1), x2.get(1)))
                .collect(Collectors.toList());
        int maxDist = maxDistance;
        while (true) {
            for (List<Integer> l : forwardList) {
                for (List<Integer> b : backwardList) {
                    int forward = l.get(1);
                    int backward = b.get(1);
                    int tot = (forward + backward);
                    if (tot > maxDist) {
                        break;
                    }
                    if (tot == maxDist) {
                        // print the pair of Id and optimum distance
                        result.add(Arrays.asList(l.get(0), b.get(0), maxDist));
                        break;
                    }

                }
            }
            if (result.size() > 0) {
                break;
            }
            maxDist--;
        }
        return result;
    }


}
