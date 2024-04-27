import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int result;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String number = String.valueOf(br.readLine());
            if(number.equals("0")) break;

            result = 0;
            int length = number.length();
            
            for(int i=0; i<length; i++) {
                int oneNum = Integer.parseInt(String.valueOf(number.charAt(i)));
                if(oneNum==0) result += 4;
                else if(oneNum==1) result += 2;
                else result += 3;
            }
            
            result += length+1;

            System.out.println(result);
        }
    }
}