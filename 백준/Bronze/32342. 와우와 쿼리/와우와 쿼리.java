import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        
        for(int i=0; i<Q; i++) {
            String input = br.readLine();
            int wowCount = 0;
            int len = input.length();
            
            for(int j=0; j<len; j++) {
                char ch = input.charAt(j);
                if(ch=='W'&&j<=len-3) {
                    if(input.substring(j, j+3).equals("WOW")) wowCount++;
                }
            }
            
            System.out.println(wowCount);
        }
    }
}