package company_questions.amazon;

import java.util.*;

public class Q11_NearestCity {

    public static void main(String[] args) {
        String[] cities = new String[]{"c1","c2","c3"};
        int[] xCoordinates = new int[]{3,2,1};
        int[] yCoordinates = new int[]{3,2,3};
        int numQuries = 3;
        String[] queries = new String[]{"c1","c2","c3"};
        System.out.println(Arrays.toString(findNearestCity(cities,xCoordinates,yCoordinates,numQuries,queries)));
    }

    static class City{
        String name;
        int posX;
        int posY;
    }

    public static Comparator<? super City> YComparator =(a,b)->{
        int v = Integer.compare(a.posY,b.posY);
        if(v==0) {
            v = a.name.compareTo(b.name);
        }
        return v;
    };

    public static Comparator<? super City> XComparator =(a,b)->{
        int v = Integer.compare(a.posX,b.posX);
        if(v==0){
            v = a.name.compareTo(b.name);
        }
        return v;
    };

    public static String[] findNearestCity(String[] cities, int[] x, int[] y, int numOfQueries, String[] queries) {
        Map<Integer,TreeSet<City>> xToYMap = new HashMap<>();
        Map<Integer,TreeSet<City>> yToXMap = new HashMap<>();
        Map<String,City> nameToCity = new HashMap<>();
        Map<String,String> mem = new HashMap<>();
        for(int i=0;i<cities.length;i++){
            City city = new City();
            city.name = cities[i];
            city.posX = x[i];
            city.posY = y[i];

            nameToCity.put(city.name,city);
            xToYMap.putIfAbsent(city.posX,new TreeSet<>(XComparator));
            xToYMap.get(city.posX).add(city);
            yToXMap.putIfAbsent(city.posY,new TreeSet<>(YComparator));
            yToXMap.get(city.posY).add(city);
        }

        String []res = new String[numOfQueries];
        for(int i =0;i<numOfQueries;i++){
            City c = nameToCity.get(queries[i]);
            if(c==null) continue;
            if(mem.containsKey(c.name)) res[i] = mem.get(c.name);
            else {
                List<City> neighbors = new ArrayList<>();
                neighbors.add(xToYMap.get(c.posX).lower(c));
                neighbors.add(xToYMap.get(c.posX).higher(c));
                neighbors.add(yToXMap.get(c.posY).lower(c));
                neighbors.add(yToXMap.get(c.posY).higher(c));
                res[i] = getClosestCity(c, neighbors);
                mem.putIfAbsent(c.name, res[i]);
                mem.putIfAbsent(res[i], c.name);
            }
        }
        return res;
    }

    public static String getClosestCity(City c, List<City> neighbors){
        City target = null;
        int minDistance = Integer.MAX_VALUE;
        for(City neighbor: neighbors){
            if(neighbor!=null){
                int distance = Math.abs(c.posX-neighbor.posX) + Math.abs(c.posY-neighbor.posY);
                if(distance<minDistance){
                    target = neighbor;
                    minDistance = distance;
                }
            }
        }
        return target==null?null:target.name;
    }
}
