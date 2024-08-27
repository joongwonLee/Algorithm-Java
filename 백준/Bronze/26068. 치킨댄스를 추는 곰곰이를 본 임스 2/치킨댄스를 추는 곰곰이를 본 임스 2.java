import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int chickenCount = 0;
        
        while(N-->0) {
            String[] splitArray = br.readLine().split("-");
            if(Integer.parseInt(splitArray[1])<=90) chickenCount++;
        }
        
        System.out.println(chickenCount);
    }
}