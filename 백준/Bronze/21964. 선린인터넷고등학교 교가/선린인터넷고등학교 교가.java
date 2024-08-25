import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] inputArray = br.readLine().toCharArray();
        
        for(int i=0; i<5; i++) {
            System.out.print(inputArray[N-5+i]);
        }
    }
}