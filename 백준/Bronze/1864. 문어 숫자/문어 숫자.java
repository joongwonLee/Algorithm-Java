import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            if(input.equals("#")) break;
            
            long result = 0;
            
            char[] charArray = input.toCharArray();
            for(int i=0; i<charArray.length; i++) {
                int seq = charArray.length-i-1;
                result += getNumFromChar(charArray[i]) * Math.pow(8, seq);
            }
            
            System.out.println(result);
        }
    }
    
    public static int getNumFromChar(char ch) {
        switch(ch) {
            case '-':
                return 0;
            case '\\':
                return 1;
            case '(':
                return 2;
            case '@':
                return 3;
            case '?':
                return 4;
            case '>':
                return 5;
            case '&':
                return 6;
            case '%':
                return 7;
            case '/':
                return -1;
            default:
                return Integer.MIN_VALUE;
        }
    }
}