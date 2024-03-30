import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int N, M;
    static HashMap<String, String> maps;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());
        
        maps = new HashMap<>();
        
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            
            String address = String.valueOf(stn.nextToken());
            String password = String.valueOf(stn.nextToken());
            
            maps.put(address, password);
        }
        
        for(int i=0; i<M; i++) {
            String findAddress = String.valueOf(br.readLine());
            System.out.println(maps.get(findAddress));
        }
    }
}