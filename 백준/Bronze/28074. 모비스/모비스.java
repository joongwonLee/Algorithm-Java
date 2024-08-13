import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        boolean[] ISMOBIS = new boolean[5];
        
        for(int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            
            switch(ch) {
                case 'M':
                    ISMOBIS[0] = true;
                    break;
                case 'O':
                    ISMOBIS[1] = true;
                    break;
                case 'B':
                    ISMOBIS[2] = true;
                    break;
                case 'I':
                    ISMOBIS[3] = true;
                    break;
                case 'S':
                    ISMOBIS[4] = true;
                    break;
            }
        }
        
        for(int i=0; i<5; i++) {
            if(!ISMOBIS[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}