import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        String N = stn.nextToken();
        String M = stn.nextToken();
        
        if(N.equals(M)) System.out.println(1);
        else System.out.println(0);
    }
}