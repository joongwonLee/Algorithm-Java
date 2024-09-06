import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            char[] inputArray = br.readLine().toCharArray();
            int length = inputArray.length;
            
            if(inputArray[length/2-1]==inputArray[length/2]) System.out.println("Do-it");
            else System.out.println("Do-it-Not");
        }
    }
}