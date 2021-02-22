package company_questions.amazon.VO;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {


    //using stack
    public String decodeString(String s) {
         //edge cases:
         if(s==null||s.length()==0) return "";

         //solution:
         //initiate two stacks, one to store the number, one for string
         //initiate String res, String cur. number= 0;
         //345[a2[c]]

         //numStack: 345, 2
         //strStack: "" , a
         //String cur = "c";
         //loop over the stacks: c=>acc=>(""+acc)*345

         int index = 0;
         Stack<Integer> numStack = new Stack<>();
         Stack<String> strStack = new Stack<>();
         StringBuilder cur = new StringBuilder();
         while(index<s.length()){
             char c = s.charAt(index);
             if(Character.isDigit(c)){
                 int number = c -'0';
                 while(index+1<s.length()&&Character.isDigit(s.charAt(index+1))){
                     number = number*10+(s.charAt(index+1)-'0');
                     index++;
                 }
                 numStack.push(number);
                 index++;
             } else if (c == '['){
                 strStack.push(cur.toString());
                 cur = new StringBuilder();
                 index++;
             } else if (c==']'){
                 StringBuilder temp = new StringBuilder(strStack.pop());
                 int times = numStack.pop();
                 for(int i=0;i<times;i++){
                     temp.append(cur);
                 }
                 cur = temp;
                 index++;
             } else {
                 cur.append(c);
                 index++;
             }
         }

         return cur.toString();

    }


    //recursive
    public String decodeString2(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return helper(queue);
    }

    public String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c= queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) sb.append(sub);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
