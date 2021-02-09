package company_questions.amazon.OA;

import java.util.*;

public class Q41_LRUCacheCountMiss {
    public static void main(String[] args) {
        int num = 6;
        int[] page = new int[]{1, 2, 1, 3, 1, 2};
        List<Integer> pages = new ArrayList<>();
        for (int num2 : page) pages.add(num2);
        int maxCacheSize = 2;
        System.out.println(lruCacheMisses(num, pages, maxCacheSize));
    }

    public static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int page : pages) {
            System.out.println(page);
            System.out.println(queue);
            if(!queue.contains(page)){
                if(queue.size()==maxCacheSize) {
                    count++;
                    queue.poll();
                    queue.add(page);
                } else if (queue.size()<maxCacheSize){
                    queue.add(page);
                }
            }
        }
        return count;
    }

    //online solution
    public int Solution(int[] array, int size) {
        if (array == null)  return 0;
        List<Integer> cache = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (cache.contains(array[i])) {
                cache.remove(new Integer(array[i]));
            }
            else {
                count++;
                if (size == cache.size())
                    cache.remove(0);
            }
            cache.add(array[i]);
        }
        return count;
    }
}
