package company_questions.amazon.OA;

import java.util.*;

public class Q2_FetchItemToDisplay {
    public static void main(String[] args) {
        Map<String, PairInt> map = new HashMap<>();
        map.put("item1", new PairInt(10,15));
        map.put("item2", new PairInt(3,4));
        map.put("item3", new PairInt(17,8));
        System.out.println(fetchItemsToDisplay(3,map,1,0,2,1));
    }
    public static List<String> fetchItemsToDisplay(int numOfItems, Map<String, PairInt> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber){
        if(itemsPerPage*(pageNumber-1)>numOfItems||numOfItems==0) return null;
        List<String> res = sortItems2(items,sortParameter,sortOrder);
//        System.out.println(res);
        List<String> res2 = new ArrayList<>();
        for(int i=pageNumber*itemsPerPage;i<itemsPerPage*(pageNumber+1);i++){
            if(i>=numOfItems) break;
            res2.add(res.get(i));
        }
        return res2;
    }

    public static List<String> sortItems2(Map<String, PairInt> items, int sortParameter, int sortOrder){
        String[] arr = items.keySet().toArray(new String[0]);
        Arrays.sort(arr,(o1,o2)->{
            PairInt pairInt1 = items.get(o1);
            PairInt pairInt2 = items.get(o2);
            if(sortParameter==0) {
                if(sortOrder==0) {
                    return o1.compareTo(o2);
                } else {
                    return o2.compareTo(o1);
                }
            } else if(sortParameter==1){
                if(sortOrder==0) return Integer.compare(pairInt1.relevance,pairInt2.relevance);
                else return Integer.compare(pairInt2.relevance,pairInt1.relevance);
            } else if(sortParameter==2){
                if(sortOrder==0) return Integer.compare(pairInt1.price,pairInt2.price);
                else return Integer.compare(pairInt2.price,pairInt1.price);
            } else {
                return 0;
            }
        });
        return Arrays.asList(arr);
    }

    //bubble sort is very slow
    public static List<String> sortItems(Map<String, PairInt> items, int sortParameter, int sortOrder){
        String[] arr = items.keySet().toArray(new String[0]);
        int z = 0;
        for(String name: items.keySet()) arr[z++] = name;
        String temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j =i+1;j<arr.length-1-i;j++){
                if(sortParameter==0){
                    if(sortOrder==0){
                        if(arr[i].compareTo(arr[j])>0){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    } else if (sortOrder==1){
                        if(arr[i].compareTo(arr[j])<0){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                } else if(sortParameter==1){
                    if(sortOrder==0){
                        if(items.get(arr[i]).relevance>items.get(arr[i]).relevance){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    } else if (sortOrder==1){
                        if(items.get(arr[i]).relevance<items.get(arr[i]).relevance){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                } else if(sortParameter==2){
                    if(sortOrder==0){
                        if(items.get(arr[i]).price>items.get(arr[i]).price){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    } else if (sortOrder==1){
                        if(items.get(arr[i]).price<items.get(arr[i]).price){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
            }
        }

        return Arrays.asList(arr);
    }
}

class PairInt{
    public int relevance;
    public int price;

    public PairInt(){};
    public PairInt(int relevance,int price){
        this.relevance = relevance;
        this.price = price;
    }

}
