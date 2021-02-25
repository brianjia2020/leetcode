package company_questions.amazon.VO;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    class MedianFinder {
        private Queue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        private Queue<Integer> max = new PriorityQueue<>();
        boolean even = true;

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            if(even){
                max.offer(num);
                min.offer(max.poll());
            } else {
                min.offer(num);
                max.offer(min.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if(even) return (min.peek()+max.peek())/2.0;
            else return min.peek();
        }
    }
}
