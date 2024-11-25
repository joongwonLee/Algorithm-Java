import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int maxLevel = 0;
        int[] levelArray = new int[n];
        StringTokenizer stn = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int level = Integer.parseInt(stn.nextToken());
            maxLevel = Math.max(maxLevel, level);
            levelArray[i] = level;
        }
        
        int maxGold = 0;
        for(int i=0; i<n; i++) {
            maxGold += (maxLevel + levelArray[i]);
        }
        maxGold -= (2*maxLevel);
        System.out.println(maxGold);
    }
}