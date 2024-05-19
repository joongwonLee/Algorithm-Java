import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int R1 = Integer.parseInt(stn.nextToken());
        int S = Integer.parseInt(stn.nextToken());
        
        System.out.println(2*S-R1);
    }
}