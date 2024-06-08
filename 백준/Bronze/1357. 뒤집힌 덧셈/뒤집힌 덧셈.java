import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        String X = stn.nextToken();
        String Y = stn.nextToken();
        
        int reversedX = Integer.parseInt(getReverse(X));
        int reversedY = Integer.parseInt(getReverse(Y));
        
        String result = getReverse(String.valueOf(reversedX+reversedY));
        System.out.println(Integer.parseInt(result));
    }
    
    public static String getReverse(String num) {
        String reversed = "";
        
        for(int i=num.length()-1; i>=0; i--) {
            reversed += num.charAt(i);
        }
        
        return reversed;
    }
}