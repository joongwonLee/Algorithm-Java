import java.util.*;
import java.io.*;

class Solution {
    
    static int number;
    static int K;
    
    
    static String KJinsu;
    
    public int solution(int n, int k) {
        number = n; 
        K = k;
        
        KJinsu = changeToK();
        // System.out.println(KJinsu);
        
        return calcPrimeNum(KJinsu);
    }
    
    // 주어진 양의 정수를 K 진수로 변환하는 함수
    public String changeToK() {
        
        String str = "";
        
        int cnt = 0;
        
        for(int i=0; Math.pow(K, i) <= number; i++) {
            cnt = i;
        }
        
        for(int i=cnt; i>0; i--) {
            int powValue = (int)Math.pow(K, i);
            
            // System.out.println("number:"+number+" , powValue: "+powValue);
            
            if(powValue<number) {
                int mock = number/powValue;
                str += number/powValue;
                number -= (mock*powValue);
            } 
            else {
                str += "0";
            }
            
            // System.out.println(str);
        }
        
        str += number;
        
        return str;
    }
    
    // 문자열 값에서 소수의 개수 계산하는 함수
    public int calcPrimeNum(String jinsu) {
        
        Queue<Character> queue = new LinkedList<>();
        
        int result = 0;
        
        for(int i=0; i<jinsu.length(); i++) {
            
            char c = jinsu.charAt(i);
            
            if(c=='0') {
                String s = "";
                while(!queue.isEmpty()) {
                    s += String.valueOf(queue.poll());
                }
                Long value = (s.length()!=0) ? Long.parseLong(s) : 0;
                if(isPrimeNum(value)) {
                    result++;
                    // System.out.println(value);
                }
            } else {
                queue.offer(c);
            }
        }
        
                    String st = "";
            while(!queue.isEmpty()) {
                st += String.valueOf(queue.poll());
            }
            
            Long valuevalue = (st.length()!=0) ? Long.parseLong(st) : 0;
            if(isPrimeNum(valuevalue)) {
                result++;
                // System.out.println(valuevalue);
            }
        
        return result;
    }
    
//     public int calcPrimeNum(String jinsu) {
        
//         int cnt = 0;
//         first:
//         for(int i=0; i<=jinsu.length(); i++) {
            
//             second:
//             for(int j=0; j<i; j++) {
                
//                 // // 마지막 조건 체크 
//                 // if(j==0||i==jinsu.length()-1) {
//                 //     if(isPrimeNum(value)) cnt++;
//                 //     break second;
//                 // }
                
//                 String sub = jinsu.substring(j,i);
//                 // System.out.println(sub);
//                 char[] charList = sub.toCharArray();
                
//                 if(charList[0]=='0'||charList[charList.length-1]=='0') {
                    
//                     if(charList.length>=3) {
//                         for(int k=1; k<charList.length-1; k++) {
//                             if(charList[k]=='0') continue second;
//                         }
//                     }
                    
//                     long value;
//                     if(charList[charList.length-1]=='0'&&charList.length>=2) {
//                         value = Long.parseLong(sub.substring(0, sub.length()-1));
//                     } else {
//                         value = Long.parseLong(sub);
//                     }
//                 // System.out.println("i: "+i+" , j: "+j+", value: "+value);
//                     if(isPrimeNum(value)) {
//                         cnt++;
//                         System.out.println(value);
//                     }
//                 }
//             }
//         }
        
//         return cnt;
//     }
    
    // 소수인지 판별하는 함수 
    public boolean isPrimeNum(long x) {
        
        if(x==0||x==1) return false;
        if(x==2) return true;
        
        for(int i=2; i<=Math.sqrt(x); i++) {
            
            if(x%i==0) return false;
        }
        
        return true;
    } 
}