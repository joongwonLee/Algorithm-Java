import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N-->0) {
            String[] strArray = br.readLine().split("-");
            int diff = (int)Math.abs(getTwentySixJinBub(strArray[0])-Integer.parseInt(strArray[1]));
            if(diff<=100) System.out.println("nice");
            else System.out.println("not nice");
        }
    }
    
    public static int getTwentySixJinBub(String str) {
        int len = str.length();
        int twentySixJinBub = 0;
        for(int i=0; i<len; i++) {
            twentySixJinBub += ((int)str.charAt(i)-65)*(int)Math.pow(26, len-i-1);
        }
        
        return twentySixJinBub;
    }
}