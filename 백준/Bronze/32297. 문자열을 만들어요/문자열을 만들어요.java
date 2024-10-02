import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        boolean fromGori = false;
        
        for(int i=0; i<N; i++) {
            char ch = input.charAt(i);
            
            if(ch=='g' && i<=N-4) {
                String sub = input.substring(i, i+4);
                if(sub.equals("gori")) fromGori = true;
            } 
        }

        if(fromGori) System.out.println("YES");
        else System.out.println("NO");
    } 
}