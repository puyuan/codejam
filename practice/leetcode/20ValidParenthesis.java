/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> paranMap = new HashMap<Character, Character>();
        paranMap.put(')', '(');
        paranMap.put(']', '[');
        paranMap.put('}', '{');
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ')' || s.charAt(i) == ']'  || s.charAt(i)=='}') {
                if (st.empty())
                    return false;
                Character firstParan = st.pop();
                if (firstParan == paranMap.get(s.charAt(i)))
                    continue;
                else
                    return false;
            }
            else{
                st.push(s.charAt(i));
            }
            
        }
        if (st.empty())
            return true;
        else
            return false;
    }
}