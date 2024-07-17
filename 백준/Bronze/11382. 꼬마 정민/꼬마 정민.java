import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(stn.nextToken());
        long b = Long.parseLong(stn.nextToken());
        long c = Long.parseLong(stn.nextToken());
        
        System.out.println(a+b+c);
    }
}