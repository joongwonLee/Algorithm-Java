import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chArray = br.readLine().toCharArray();
        int[] numArray = new int[26];
        
        for(int i=0; i<chArray.length; i++) {
            numArray[chArray[i]-97]+=1;
        }
        
        for(int i=0; i<numArray.length; i++) {
            System.out.print(numArray[i]+" ");
        }
    }
}