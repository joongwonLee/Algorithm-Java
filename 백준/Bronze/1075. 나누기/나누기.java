import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int F = Integer.parseInt(br.readLine());
        
        int len = N.length();
        
        int start = Integer.parseInt(N.substring(0, len-2)+"00");
        int end = Integer.parseInt(N.substring(0, len-2)+"99");
        
        for(int i=start; i<=end; i++) {
            if(i%F==0) {
                System.out.println(String.valueOf(i).substring(len-2, len));
                break;
            }
        }
    }
}