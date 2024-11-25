import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            
            String[] crying = br.readLine().split(" ");
            StringBuffer foxCry = new StringBuffer();
            
            List<String> cryingList = new ArrayList<>();
            
            inner:
            while(true) {
                String input = br.readLine();
                if(input.equals("what does the fox say?")) break inner;
                
                String cry = input.split(" ")[2];
                cryingList.add(cry);
            }
            
            for(int i=0; i<crying.length; i++) {
                if(!cryingList.contains(crying[i])) foxCry.append(crying[i]+" ");
            }
            
            System.out.println(foxCry);
        }
    }
}