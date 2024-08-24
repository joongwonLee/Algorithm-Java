import java.util.*;
import java.io.*;

public class Main {
    
    static String[] strArray = {"Never gonna give you up",
                                "Never gonna let you down", 
                                "Never gonna run around and desert you",
                                "Never gonna make you cry", 
                                "Never gonna say goodbye",
                                "Never gonna tell a lie and hurt you",
                                "Never gonna stop"
                               };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N-->0) {
            boolean isContain = false;
            String input = br.readLine();
            
            for(String str: strArray) {
                if(input.equals(str)) {
                    isContain = true;
                    break;
                }
            }
            
            if(!isContain) {
                System.out.println("Yes");
                return;
            }
        }
        
        System.out.println("No");
    }
}