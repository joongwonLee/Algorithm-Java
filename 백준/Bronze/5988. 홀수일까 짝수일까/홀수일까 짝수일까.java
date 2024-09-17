import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N-->0) {
            char[] numArray = br.readLine().toCharArray();
            int length = numArray.length;
            int lastNum = Integer.parseInt(String.valueOf(numArray[length-1]));
            
            if(lastNum%2==0) System.out.println("even");
            else System.out.println("odd");
        }
    }
}