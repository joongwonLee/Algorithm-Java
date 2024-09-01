import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        char[] friends = new char[N];
        for(int i=0; i<N; i++) {
            friends[i] = stn.nextToken().charAt(0);
        }
        
        char mine = br.readLine().charAt(0);
        
        int same = 0;
        for(int i=0; i<N; i++) {
            if(mine==friends[i]) same++;
        }
        System.out.println(same);
    }
}