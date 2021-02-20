package company_questions.amazon.VO;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s){
        //edges case:
        if(s==null||s.length()<2) return false;

        //solution: O(n)
        //1. build a map of key,value ( to ), { to }, [ to ]
        //2. keep a stack to keep.
        //3. loop over the string s O(n)
        //   if there is a left brackets (,{,[ O(1), we will push its corresponding right to the stack
        //   if it's not, check from the stack on the latest. O(1)
        //4. return if the stack is empty, return true. else false O(1)
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(map.get(c));
            } else {
                if(stack.isEmpty()) return false;
                else if (stack.pop()!=c) return false;
            }
        }
        return stack.isEmpty();
    }
}
