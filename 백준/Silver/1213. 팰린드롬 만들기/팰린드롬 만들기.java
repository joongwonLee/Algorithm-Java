import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        int length = message.length();
        
        int[] alphabetNum = new int[26];
        for(int i=0; i<length; i++) {
            alphabetNum[(int)message.charAt(i)-65]++;
        }

        boolean hasOdd = false;
        int oddNum = 0;
        for(int i=0; i<26; i++) {
            if(alphabetNum[i]%2!=0) {
                hasOdd = false;
                oddNum++;
            }
        }

        if((oddNum>=2)||(length%2==0 && hasOdd)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        char[] palinArray = new char[length];

        int start = 0;
        int end = length-1;
        for(int i=0; i<26; i++) {
            int num = alphabetNum[i];
            if(num%2!=0) {
                palinArray[length/2] = (char)(i+65);
            }
            for(int j=0; j<num/2; j++) {
                palinArray[start++] = (char)(i+65);
                palinArray[end--] = (char)(i+65);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for(char c: palinArray) {
            sb.append(String.valueOf(c));
        }

        System.out.println(sb);
    }
}