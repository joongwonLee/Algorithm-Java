import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int firstApple = Integer.parseInt(stn.nextToken());
        int firstOrange = Integer.parseInt(stn.nextToken());
        
        stn = new StringTokenizer(br.readLine());
        
        int secondApple = Integer.parseInt(stn.nextToken());
        int secondOrange = Integer.parseInt(stn.nextToken());
        
        System.out.println(Math.min(firstApple+secondOrange, firstOrange+secondApple));
    }
}