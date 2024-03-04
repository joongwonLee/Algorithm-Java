import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static HashMap<Integer, Integer> xMap, yMap;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        xMap = new HashMap<>();
        yMap = new HashMap<>();
        
        for(int i=0; i<3; i++) {
            stn = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(stn.nextToken());
            int y = Integer.parseInt(stn.nextToken());
            
            if(xMap.containsKey(x)) xMap.put(x, xMap.get(x)+1);
            else xMap.put(x, 1);
            
            if(yMap.containsKey(y)) yMap.put(y, yMap.get(y)+1);
            else yMap.put(y, 1);
        }
        
        for(Integer xKey: xMap.keySet()) {
            if(xMap.get(xKey)==1) System.out.print(xKey+" ");
        }
        
        for(Integer yKey: yMap.keySet()) {
            if(yMap.get(yKey)==1) System.out.print(yKey);
        }
    }
}