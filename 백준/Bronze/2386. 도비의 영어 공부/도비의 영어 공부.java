import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            
            char ch = input.charAt(0);
            if(ch=='#') break;
            
            int count = 0;
            
            for(int i=1; i<input.length(); i++) {
                if(Character.toUpperCase(input.charAt(i))==ch||Character.toLowerCase(input.charAt(i))==ch) {
                    count++;
                }
            }
            
            System.out.println(ch+" "+count);
        }
    }
}