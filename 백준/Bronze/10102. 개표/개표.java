import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        char[] votes = br.readLine().toCharArray();
        
        int ACount = 0;
        int BCount = 0;
        
        for(int i=0; i<V; i++) {
            if(votes[i]=='A') ACount++;
            else BCount++;
        }
        
        if(ACount>BCount) {
            System.out.println("A");
        } else if(ACount<BCount) {
            System.out.println("B");
        } else {
            System.out.println("Tie");
        }
    }
}