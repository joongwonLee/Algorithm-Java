import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] numArray = br.readLine().toCharArray();
        
        int evenNum = 0;
        int oddNum = 0;
        
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(String.valueOf(numArray[i]));
            if(num%2==0) evenNum++;
            else oddNum++;
        }
        
        if(evenNum > oddNum) {
            System.out.println("0");
        } else if(evenNum == oddNum) {
            System.out.println("-1");
        } else {
            System.out.println("1");
        }
    }
}