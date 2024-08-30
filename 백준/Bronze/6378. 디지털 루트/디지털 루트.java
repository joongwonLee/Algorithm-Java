import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            
            String input = br.readLine();
            if(input.equals("0")) break;
            
            while(input.length()!=1) {
                char[] inputArray = input.toCharArray();
                int sum = 0;
                for(int i=0; i<inputArray.length; i++) {
                    sum += Integer.parseInt(String.valueOf(inputArray[i]));
                }
                input = String.valueOf(sum);
            }
            
            System.out.println(input);
        }
    }
}