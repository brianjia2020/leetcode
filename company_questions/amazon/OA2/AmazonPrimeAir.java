package company_questions.amazon.OA2;

import java.util.*;

public class AmazonPrimeAir {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> getBestRoute(int maxDistance, List<List<Integer>> frontRouteList, List<List<Integer>> backRouteList){
        List<List<Integer>> emptyAns = new ArrayList<>();
        emptyAns.add(new ArrayList<Integer>());
        if(frontRouteList==null||frontRouteList.size()==0||backRouteList==null||backRouteList.size()==0) {
            return emptyAns;
        }
        Collections.sort(frontRouteList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(1),o2.get(1));
            }
        });
        Collections.sort(backRouteList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(1),o2.get(1));
            }
        });
        Map<Integer,List<List<Integer>>> combinationMem = new HashMap<>();
        int maxCombinationDistance = Integer.MIN_VALUE;
        for(List<Integer> frontRoute: frontRouteList){
            for(List<Integer> backRoute: backRouteList){
                int totalDistance = frontRoute.get(1)+backRoute.get(1);
                if(totalDistance>maxDistance) break;
                else {
                    ArrayList<Integer> combination = new ArrayList<>();
                    combination.add(frontRoute.get(0));
                    combination.add(backRoute.get(0));
                    combinationMem.putIfAbsent(totalDistance,new ArrayList<>());
                    combinationMem.get(totalDistance).add(combination);
                    maxCombinationDistance = Math.max(maxCombinationDistance,totalDistance);
                }
            }
        }
        return combinationMem.get(maxCombinationDistance);
    }
}
