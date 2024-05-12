class Solution {
    public String solution(String s) {
        String answer = "";
//         // boolean firstFlag = (s.charAt(0)==' ');
//         boolean lastFlag = (s.charAt(s.length()-1)==' ');
//         String[] strArray = s.split(" ");
        
//         for(int i=0; i<strArray.length; i++) {
//             // if(i==0&&firstFlag) answer += " ";
//             answer += getRule(strArray[i]);
//             if(i!=strArray.length-1||lastFlag) answer += " ";
//         }
        
        int startFlag = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch==' ') {
                answer += " ";
                startFlag = 0;
            } else {
                if(startFlag%2==0) answer += String.valueOf(ch).toUpperCase();
                else answer += String.valueOf(ch).toLowerCase();
                startFlag ++;
            } 
        }
        
        return answer;
    }
    
    public static String getRule(String str) {
        String ruleString = "";
        int length = str.length();
        
        for(int i=0; i<length; i++) {
            if(i%2==0) ruleString+=String.valueOf(str.charAt(i)).toUpperCase();
            else ruleString+=String.valueOf(str.charAt(i)).toLowerCase();
        }
        
        return ruleString;
    }
}