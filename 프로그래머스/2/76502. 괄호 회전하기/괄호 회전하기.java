import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int x = 0;
        if(s.length()==1) return x;
        
        String str = s;
        
        for(int i=0; i<s.length(); i++) {
            str = goLeft(str);
            if(isRightString(str)) x++;
        }
        
        return x;
    }
    
    public boolean isRightString(String s) {
        Stack<Character> stk = new Stack<>();
        String str = s;
        
        for(int i=0; i<s.length(); i++) {
            char c = str.charAt(i);
            if(c=='('||c=='{'||c=='[') {
                stk.push(c);
            } else {
                if(!stk.isEmpty()) {
                    char top = stk.pop();
                    if(c==')'&&top=='(') continue;
                    else if(c=='}'&&top=='{') continue;
                    else if(c==']'&&top=='[') continue;
                
                    return false;
                } else {
                    return false;
                }
            }
        }
        
        if(stk.isEmpty()) return true;
        else return false;
    }
    
    public String goLeft(String s) {
        String returnStr = s.substring(1,s.length());
        returnStr += s.charAt(0);
        return returnStr;
    }
}